package pe.edu.upc.easyshop.core.navigation


sealed class Route(val route: String){
    object Login: Route("login")
    object Main: Route("main")
    object ProductDetail: Route("product_detail")
}