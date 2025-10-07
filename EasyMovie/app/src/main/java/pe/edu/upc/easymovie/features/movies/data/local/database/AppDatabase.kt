package pe.edu.upc.easymovie.features.movies.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.easymovie.features.movies.data.local.dao.MovieDao
import pe.edu.upc.easymovie.features.movies.data.local.models.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}