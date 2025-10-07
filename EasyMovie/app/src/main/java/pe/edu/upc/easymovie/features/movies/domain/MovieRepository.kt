package pe.edu.upc.easymovie.features.movies.domain

interface MovieRepository {

    suspend fun searchMovie(query: String): List<Movie>

    suspend fun addFavorite(movie: Movie)

    suspend fun removeFavorite(movie: Movie)

    suspend fun getAllFavorites(): List<Movie>
}