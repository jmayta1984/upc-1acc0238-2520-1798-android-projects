package pe.edu.upc.easymovie.features.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easymovie.features.favorites.FavoritesView
import pe.edu.upc.easymovie.features.movies.presentation.SearchMovieView

@Composable
fun MainView(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    val selectedIndex = remember {
        mutableIntStateOf(0)
    }

    val navigationItems = listOf(
        NavigationItem(
            label = "Search",
            icon = Icons.Default.Movie,
            route = "search_movies"
        ),
        NavigationItem(
            label = "Favorites",
            icon = Icons.Default.Favorite,
            route = "favorites"
        )
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex.intValue == index,
                        onClick = {
                            selectedIndex.intValue = index
                            navController.navigate(item.route)
                        },
                        icon = {
                            Icon(item.icon, contentDescription = item.label)
                        },
                        label = {
                            Text(item.label)
                        }
                    )

                }
            }
        }

    ) { paddingValues ->
        NavHost(
            navController, startDestination = "search_movies",
            modifier = Modifier.padding(paddingValues)

        ) {
            composable("search_movies") {
                SearchMovieView()
            }

            composable("favorites") {
                FavoritesView()
            }
        }
    }
}

data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)