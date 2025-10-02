package pe.edu.upc.easymovie.features.movies.data.local.models

import com.google.gson.annotations.SerializedName

data class MoviesWrapperDto(
    val page: Int,
    @SerializedName("results")
    val movies: List<MovieDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)