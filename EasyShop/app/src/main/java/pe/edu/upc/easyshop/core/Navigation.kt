package pe.edu.upc.easyshop.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easyshop.features.auth.presentation.Login
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = Route.Login.route) {
        composable (Route.Login.route) {
            Login {
                navController.navigate(Route.Main.route)
            }
        }
        composable(Route.Main.route){
            Main()
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

sealed class Route(val route: String){
    object Login: Route("login")
    object Main: Route("main")
}