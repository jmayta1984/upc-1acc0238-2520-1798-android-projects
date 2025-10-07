package pe.edu.upc.easymovie.features.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easymovie.features.movies.domain.Movie
import pe.edu.upc.easymovie.features.movies.domain.MovieRepository
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    fun onQueryChange(value: String) {
        _query.value = value
    }

    fun searchMovie() {
        viewModelScope.launch {
            _movies.value = repository.searchMovie(_query.value)
        }
    }

    fun toggleFavorite(movie: Movie) {
        viewModelScope.launch {

            if (movie.isFavorite) {
                repository.removeFavorite(movie)
            } else {
                repository.addFavorite(movie)

            }
        }
        _movies.value = _movies.value.map {
            if (it.id == movie.id) {
                it.copy(isFavorite = !it.isFavorite)
            } else {
                it
            }
        }
    }
}