package pe.edu.upc.easymovie.features.movies.domain

interface MovieRepository {

    suspend fun searchMovie(query: String): List<Movie>
}