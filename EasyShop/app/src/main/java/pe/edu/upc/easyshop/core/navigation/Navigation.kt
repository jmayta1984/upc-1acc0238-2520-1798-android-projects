package pe.edu.upc.easyshop.core.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easyshop.core.root.Main
import pe.edu.upc.easyshop.features.auth.presentation.login.Login
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.auth.presentation.di.PresentationModule.getLoginViewModel

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = Route.Login.route) {
        composable (Route.Login.route) {
            Login(getLoginViewModel()) {
                navController.navigate(Route.Main.route)
            }
        }
        composable(Route.Main.route){
            Main {
                navController.navigate(Route.ProductDetail.route)
            }
        }

        composable (Route.ProductDetail.route) {
            Text("Product")
        }
    }
}

@Preview
@Composable
fun NavigationPreview(){
    EasyShopTheme {
        Navigation()
    }
}
