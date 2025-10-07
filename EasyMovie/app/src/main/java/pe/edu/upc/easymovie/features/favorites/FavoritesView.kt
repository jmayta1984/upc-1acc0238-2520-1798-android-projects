package pe.edu.upc.easymovie.features.favorites

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun FavoritesView(
    modifier: Modifier = Modifier,
    viewModel: FavoritesViewModel = hiltViewModel()
) {

    val movies = viewModel.movies.collectAsState()

    LazyColumn(modifier = modifier) {
        items(movies.value) { movie ->
            FavoriteCard(movie) {
                viewModel.removeFavorite(movie)
            }
        }
    }

}