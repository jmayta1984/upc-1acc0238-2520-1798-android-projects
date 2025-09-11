package pe.edu.upc.easyshop.shared.models

data class Product(
    val name: String,
    val price: Double,
    val image: String
)

val products = listOf(
    Product(
        "Nike React Infinity Run Flyknit",
        price = 180.0,
        image = "https://www.fit2run.com/cdn/shop/files/DH5392-007-PHSRH001-1500.png"
    ),
    Product(
        "Nike React Infinity Run Flyknit",
        price = 180.0,
        image = "https://www.fit2run.com/cdn/shop/files/DH5392-007-PHSRH001-1500.png"
    ),
    Product(
        "Nike React Infinity Run Flyknit",
        price = 180.0,
        image = "https://www.fit2run.com/cdn/shop/files/DH5392-007-PHSRH001-1500.png"
    )

)
