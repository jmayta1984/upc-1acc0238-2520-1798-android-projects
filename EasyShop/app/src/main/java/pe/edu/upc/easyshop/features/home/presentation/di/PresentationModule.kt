package pe.edu.upc.easyshop.features.home.presentation.di

import pe.edu.upc.easyshop.features.home.data.di.DataModule.getProductRepository
import pe.edu.upc.easyshop.features.home.presentation.home.HomeViewModel
import pe.edu.upc.easyshop.features.home.presentation.productdetail.ProductDetailViewModel

object PresentationModule {
    fun getHomeViewModel(): HomeViewModel {
        return HomeViewModel(getProductRepository())
    }

    fun getProductDetailViewModel(): ProductDetailViewModel {
        return ProductDetailViewModel(getProductRepository())
    }
}