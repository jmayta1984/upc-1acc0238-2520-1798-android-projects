package pe.edu.upc.easymovie.features.movies.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    @ColumnInfo("poster_path")
    val posterPath: String,
    val overview: String
)
