package pe.edu.upc.easymovie.features.movies.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Preview(showBackground = true)
@Composable

fun SearchMovieView(
    modifier: Modifier = Modifier,
    viewModel: SearchMovieViewModel = hiltViewModel()
) {
    val query = viewModel.query.collectAsState()
    val movies = viewModel.movies.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        OutlinedTextField(
            value = query.value,
            onValueChange = {
                viewModel.onQueryChange(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            placeholder = { Text("Search") },
            trailingIcon = {
                IconButton(
                    onClick = {
                        viewModel.searchMovie()
                    }
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null
                    )
                }
            }
        )

        LazyColumn {
            items(movies.value) { movie ->
                MovieCard(movie) {
                    viewModel.toggleFavorite(movie)
                }
            }
        }
    }

}
