package pe.edu.upc.easyshop.core.root

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.home.presentation.di.PresentationModule.getHomeViewModel
import pe.edu.upc.easyshop.features.home.presentation.views.Home

@Composable
fun Main(onClick: () -> Unit) {
    val selectedIndex = remember {
        mutableIntStateOf(0)
    }

    val navigationItems = listOf(
        NavigationItem(icon = Icons.Default.Home, label = "Home"),
        NavigationItem(icon = Icons.Default.Favorite, label = "Favorite"),
        NavigationItem(icon = Icons.Default.ShoppingCart, label = "Cart"),
        NavigationItem(icon = Icons.Default.Person, label = "Profile"),
    )

    Scaffold(
        bottomBar = {
            BottomAppBar {
              navigationItems.forEachIndexed { index, item ->
                  NavigationBarItem(
                      selected = selectedIndex.intValue == index,
                      icon = {
                          Icon(item.icon, contentDescription = item.label)
                      },

                      label = {
                          Text(text = item.label)
                      },
                      onClick = {
                          selectedIndex.intValue = index
                      }
                  )
              }
            }
        }

    ) {
        Column(modifier = Modifier.padding(it)) {
            Home(getHomeViewModel(),onClick)
        }

    }
}


data class NavigationItem(val icon: ImageVector, val label: String)

@Preview
@Composable
fun MainPreview() {
    EasyShopTheme {
        Main{}
    }
}