package pe.edu.upc.easyshop.core.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.easyshop.core.root.Main
import pe.edu.upc.easyshop.features.auth.presentation.login.Login
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.auth.presentation.di.PresentationModule.getLoginViewModel
import pe.edu.upc.easyshop.features.home.presentation.di.PresentationModule.getProductDetailViewModel
import pe.edu.upc.easyshop.features.home.presentation.productdetail.ProductDetail
import pe.edu.upc.easyshop.features.home.presentation.productdetail.ProductDetailViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Route.Login.route) {
        composable(Route.Login.route) {
            Login(getLoginViewModel()) {
                navController.navigate(Route.Main.route)
            }
        }
        composable(Route.Main.route) {
            Main { productId ->
                navController.navigate("${Route.ProductDetail.route}/$productId")
            }
        }

        composable(
            route = Route.ProductDetail.routeWithArgument,
            arguments = listOf(navArgument(Route.ProductDetail.argument) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.let { arguments ->
                val productId = arguments.getInt(Route.ProductDetail.argument)
                val productDetailViewModel = getProductDetailViewModel()
                productDetailViewModel.getProductById(productId)
                ProductDetail(productDetailViewModel)
            }
        }
    }
}

@Preview
@Composable
fun NavigationPreview() {
    EasyShopTheme {
        Navigation()
    }
}
