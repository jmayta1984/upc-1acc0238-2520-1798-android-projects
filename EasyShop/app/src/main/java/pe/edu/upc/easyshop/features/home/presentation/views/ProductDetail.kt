package pe.edu.upc.easyshop.features.home.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easyshop.core.ui.components.RoundedIcon
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.shared.models.Product

@Composable
fun ProductDetail(product: Product) {
    Scaffold (
        floatingActionButton = {
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
                Button(onClick = {}, modifier = Modifier.weight(1f)) {
                    Text("Add to cart")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = {}, modifier = Modifier.weight(1f)) {
                    Text("Buy now")
                }
            }

        },
        floatingActionButtonPosition = FabPosition.Center

    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            AsyncImage(
                product.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
                    .background(MaterialTheme.colorScheme.onPrimary),
                contentScale = ContentScale.FillWidth
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(product.name, fontWeight = FontWeight.SemiBold)
                Text("$ ${product.price}", fontWeight = FontWeight.SemiBold)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                RoundedIcon(Icons.Default.Remove)
                Text("1", modifier = Modifier.padding(8.dp))
                RoundedIcon(Icons.Default.Add)
            }

        }
    }
}

