package pe.edu.upc.easymovie.features.movies.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pe.edu.upc.easymovie.features.movies.data.repositories.MovieRepositoryImpl
import pe.edu.upc.easymovie.features.movies.domain.MovieRepository

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun provideMovieRepository(impl: MovieRepositoryImpl): MovieRepository
}