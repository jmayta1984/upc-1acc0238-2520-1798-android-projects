package pe.edu.upc.easymovie.features.movies.data.remote

import pe.edu.upc.easymovie.features.movies.data.local.models.MoviesWrapperDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.themoviedb.org/3/search/movie?api_key=3cae426b920b29ed2fb1c0749f258325&query=batman
interface MovieService {

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325",
        @Query("query") query: String
    ): Response<MoviesWrapperDto>
}