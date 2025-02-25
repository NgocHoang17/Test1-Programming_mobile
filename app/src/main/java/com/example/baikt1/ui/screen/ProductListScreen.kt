package com.example.baikt1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baikt1.R
import com.example.baikt1.data.Product

@Composable
fun ProductListScreen(navController: NavController) {
    val products = listOf(
        Product(1, "DANVOUY Womens T Shirt", "Đây là một chiếc áo thun của thương hiệu DANVOUY, được làm từ chất liệu 95% cotton và 5% spandex ", 12.99, R.drawable.ao_thun, 4.5),
        Product(2, "Opna Women's Short Sleeve", "100% Polyester, Machine Wash", 7.95, R.drawable.ao_thun2, 4.0),
        Product(3, "MBJ Women's Solid Short", "95% Rayon, Made in USA", 9.85, R.drawable.ao_thun3, 4.6),
        Product(4, "Rain Jacket Women", "Lightweight, waterproof, stylish", 39.99, R.drawable.ao_khoac_mua, 0.0),
        Product(5, "Jacket Women", "Áo khoác sành điệu vừa giữ ấm cho cơ thể vừa tạo sự sang trọng cho người mặc", 28.98, R.drawable.ao_khoac, 0.0),
        Product(6, "Rain Jacket Women", "Lightweight, waterproof, stylish", 39.99, R.drawable.ao_khoac, 0.0),
        Product(7, "Rain Jacket Women", "Lightweight, waterproof, stylish", 39.99, R.drawable.ao_khoac, 0.0)

    )

    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(products) { product ->
            ProductItem(product) {
                navController.navigate("productDetail/${product.id}")
            }
        }
    }
}

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            // Hình ảnh sản phẩm
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )

            // Thông tin sản phẩm
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = product.description, fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(4.dp))

                // Hiển thị số sao
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "⭐ ${product.rating}", fontSize = 12.sp, color = Color(0xFFFFA000))
                }

                Spacer(modifier = Modifier.height(4.dp))

                // Giá tiền
                Text(
                    text = "$${product.price}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF388E3C)
                )
            }

            // Nút "+" để thêm vào giỏ hàng
//            IconButton(onClick = { /* TODO: Xử lý thêm vào giỏ hàng */ }) {
//                Icon(
//                    painter = painterResource(id = R.drawable.ic_add), // Đảm bảo `ic_add` tồn tại trong `drawable`
//                    contentDescription = "Add to cart",
//                    tint = Color(0xFF388E3C) // Định dạng đúng của Color
//                )
//            }

        }
    }
}
