package pe.edu.upc.easyshop

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easyshop.ui.theme.EasyShopTheme

@Composable
fun Navigation(){
    val navController = rememberNavController()


    NavHost(navController, startDestination = "login") {
        composable ("login") {
            Login {
                navController.navigate("main")
            }
        }

        composable("main"){
            Main()
        }
    }

}

@Preview
@Composable
fun NavigationPreview(){
    EasyShopTheme (dynamicColor = false){
        Navigation()
    }
}