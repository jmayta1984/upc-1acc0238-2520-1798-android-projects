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

                    return@withContext productsDto.map { productDto ->
                        Product(
                            name = productDto.title ?: "",
                            price = productDto.price ?: 0.0,
                            image = productDto.thumbnail ?: "",
                            id = productDto.id ?: 0
                        )

                    }


                }
            }
        }

        return@withContext emptyList()
    }

    override suspend fun getProductById(id: Int): Product? = withContext(Dispatchers.IO) {

        val response = service.getProductById(id)

        if (response.isSuccessful) {
            response.body()?.let { productDto ->
                return@withContext Product(
                    id = productDto.id ?: 0,
                    name = productDto.title ?: "",
                    price = productDto.price ?: 0.0,
                    image = productDto.thumbnail ?: ""
                )
            }
        }

        return@withContext null
    }

    override suspend fun addFavorite(product: Product) = withContext(Dispatchers.IO) {
        dao.insert(ProductEntity (
            id = product.id,
            name = product.name,
            price = product.price,
            image = product.image
        ))
    }


}