package pe.edu.upc.easymovie.features.movies.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import pe.edu.upc.easymovie.features.movies.domain.Movie

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
                MovieCard(movie)
            }
        }
    }

}


@Composable
fun MovieCard(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
    {
        Row {
            AsyncImage(
                model = movie.image,
                contentDescription = null,
                modifier = Modifier
                    .height(112.dp)
                    .width(64.dp)
                    .clip(RoundedCornerShape(8.dp))
                ,
                contentScale = ContentScale.FillHeight
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(movie.title, maxLines = 1, style = MaterialTheme.typography.titleSmall)
                Text(movie.overview, maxLines = 2, style = MaterialTheme.typography.labelMedium)
            }
        }

    }
}
