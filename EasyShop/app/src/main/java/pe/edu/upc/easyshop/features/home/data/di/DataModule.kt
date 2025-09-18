package pe.edu.upc.easyshop.features.home.data.di

import pe.edu.upc.easyshop.features.home.data.remote.services.ProductService
import pe.edu.upc.easyshop.features.home.data.repositories.ProductRepositoryImpl
import pe.edu.upc.easyshop.features.home.domain.repositories.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getProductRepository(): ProductRepository {
        return ProductRepositoryImpl(getProductService())
    }

    fun getProductService(): ProductService {
        return getRetrofit().create(ProductService::class.java)
    }

    fun getRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}