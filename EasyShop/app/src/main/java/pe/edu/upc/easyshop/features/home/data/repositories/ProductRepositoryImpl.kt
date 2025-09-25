package pe.edu.upc.easyshop.features.home.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.easyshop.features.home.data.local.dao.ProductDao
import pe.edu.upc.easyshop.features.home.data.local.models.ProductEntity
import pe.edu.upc.easyshop.features.home.data.remote.services.ProductService
import pe.edu.upc.easyshop.features.home.domain.repositories.ProductRepository
import pe.edu.upc.easyshop.shared.models.Product

class ProductRepositoryImpl(
    private val service: ProductService,
    private val dao: ProductDao

) : ProductRepository {
    override suspend fun getAllProducts(): List<Product> = withContext(Dispatchers.IO) {
        val response = service.getAllProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsWrapperDto ->
                productsWrapperDto.products?.let { productsDto ->

                    productsDto.forEach { productDto ->
                        dao.insert(
                            ProductEntity(
                                id = productDto.id ?: 0,
                                name = productDto.title ?: "",
                                price = productDto.price ?: 0.0,
                                image = productDto.thumbnail ?: ""
                            )
                        )
                    }
                    return@withContext productsDto.map { productDto ->
                        Product(
                            name = productDto.title ?: "",
                            price = productDto.price ?: 0.0,
                            image = productDto.thumbnail ?: ""
                        )

                    }


                }
            }
        }

        return@withContext emptyList()
    }
}