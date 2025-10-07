package pe.edu.upc.easymovie.features.movies.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.easymovie.features.movies.data.remote.MovieService
import pe.edu.upc.easymovie.features.movies.domain.Movie
import pe.edu.upc.easymovie.features.movies.domain.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val service: MovieService) : MovieRepository {
    override suspend fun searchMovie(query: String): List<Movie> = withContext(Dispatchers.IO) {
        val response = service.searchMovie(query = query)

        if (response.isSuccessful) {
            response.body()?.let { wrapperDto ->
                return@withContext wrapperDto.movies.map { movieDto ->
                    Movie(
                        id = movieDto.id,
                        title = movieDto.title,
                        image = "https://image.tmdb.org/t/p/w500/${movieDto.posterPath ?: ""}",
                        overview = movieDto.overview

                    )
                }

            }
        }

        return@withContext emptyList()
    }
}