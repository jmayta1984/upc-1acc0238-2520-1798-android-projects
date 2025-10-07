package pe.edu.upc.easymovie.features.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easymovie.features.movies.domain.Movie

@Composable
fun FavoriteCard(
    movie: Movie,
    onRemoveFavorite: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    )
    {
        Row(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = movie.image,
                contentDescription = null,
                modifier = Modifier
                    .height(112.dp)
                    .width(64.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillHeight
            )

            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(movie.title, maxLines = 1, style = MaterialTheme.typography.titleSmall)
                Text(movie.overview, maxLines = 2, style = MaterialTheme.typography.labelMedium)
            }

            IconButton(
                onClick = onRemoveFavorite
            ) {
                Icon(

                    Icons.Default.Delete,
                    contentDescription = null
                )
            }

        }

    }
}
