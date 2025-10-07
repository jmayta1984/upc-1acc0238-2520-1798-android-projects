package pe.edu.upc.easymovie.features.movies.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.easymovie.features.movies.data.local.models.MovieEntity

@Dao
interface MovieDao {

    @Insert
    suspend fun insert(vararg entity: MovieEntity)

    @Query("delete from movies where id=:id")
    suspend fun deleteById(id: Int)

    @Query("select exists(select 1 from movies where id=:id)")
    suspend fun existsFavorite(id: Int): Boolean


    @Query("select * from movies")
    suspend fun getAllFavorites(): List<MovieEntity>

}