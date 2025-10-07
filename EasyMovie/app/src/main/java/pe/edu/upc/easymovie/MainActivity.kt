package pe.edu.upc.easymovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import pe.edu.upc.easymovie.core.ui.theme.EasyMovieTheme
import pe.edu.upc.easymovie.features.movies.presentation.SearchMovieView

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EasyMovieTheme {
                Scaffold { paddingValues ->
                    SearchMovieView(modifier = Modifier.padding(paddingValues))

                }
            }
        }
    }
}