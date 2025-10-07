package pe.edu.upc.easymovie.features.movies.domain

data class Movie(
    val id: Int,
    val title: String,
    val image: String,
    val overview: String,
    val isFavorite: Boolean = false
)
