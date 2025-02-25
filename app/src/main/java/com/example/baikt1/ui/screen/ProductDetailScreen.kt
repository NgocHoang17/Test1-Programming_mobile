package com.example.baikt1.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
fun ProductDetailScreen(productId: Int, navController: NavController) {
    // Dữ liệu sản phẩm mẫu (giữ nguyên như danh sách sản phẩm ở `ProductListScreen.kt`)
    val products = listOf(
        Product(1, "DANVOUY Womens T Shirt", "Đây là một chiếc áo thun của thương hiệu DANVOUY, được làm từ chất liệu 95% cotton và 5% spandex, mang lại sự thoải mái và linh hoạt. Thiết kế thời trang, phù hợp để mặc hàng ngày hoặc trong các hoạt động nhẹ nhàng.", 12.99, R.drawable.ao_thun, 4.5),
        Product(2, "Opna Women's Short Sleeve", "100% Polyester, Machine Wash", 7.95, R.drawable.ao_thun2, 0.0),
        Product(3, "MBJ Women's Solid Short", "95% Rayon, Made in USA", 9.85, R.drawable.ao_thun3, 0.0),
        Product(4, "Rain Jacket Women", "Lightweight, waterproof, stylish", 39.99, R.drawable.ao_khoac_mua, 0.0),
        Product(5, "Jacket Women", "Áo khoác sành điệu vừa giữ ấm cho cơ thể vừa tạo sự sang trọng cho người mặc", 39.99, R.drawable.ao_khoac, 0.0),
        Product(6, "Rain Jacket Women", "Lightweight, waterproof, stylish", 39.99, R.drawable.ao_khoac, 0.0),
        Product(7, "Rain Jacket Women", "Lightweight, waterproof, stylish", 39.99, R.drawable.ao_khoac, 0.0)
    )

    val product = products.find { it.id == productId }

    product?.let {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Nút quay lại
//            IconButton(onClick = { navController.popBackStack() }) {
//                Icon(painter = painterResource(id = R.drawable.ic_arrow_back), contentDescription = "Back")
//            }
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                IconButton(onClick = { navController.popBackStack() }) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "Quay lại",
//                        modifier = Modifier.size(32.dp),
//                        tint = Color.Black
//                    )
//                }
//            }


            Spacer(modifier = Modifier.height(8.dp))

            // Tiêu đề sản phẩm
            Text(text = it.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(4.dp))

            // Đánh giá sao
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "⭐ ${it.rating}", fontSize = 16.sp, color = Color(0xFFFFA500))
                Text(text = " (2 Reviews)", fontSize = 14.sp, color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Ảnh sản phẩm
            Image(
                painter = painterResource(id = it.imageRes),
                contentDescription = it.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Mô tả sản phẩm
            Text(text = it.description, fontSize = 14.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(8.dp))

            Divider(color = Color.LightGray, thickness = 1.dp)

            Spacer(modifier = Modifier.height(8.dp))

            // Tiêu đề "Reviews"
            Text(text = "Reviews", fontSize = 16.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(8.dp))

            // Giá sản phẩm
            Text(text = "$${it.price}", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))

            // Nút "Add to Cart"
//            Row {
//                Button(
//                    onClick = {
//                        Toast.makeText(
//                            context,
//                            "${it.name} đã được thêm vào giỏ hàng",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    },
//                    shape = RoundedCornerShape(8.dp),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(50.dp),
//                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9370DB))
//                ) {
//                    Text(text = "ADD TO CART", fontSize = 16.sp, color = Color.White)
//                }
//            }
        }
    } ?: run {
        Text("Sản phẩm không tồn tại", color = Color.Red)
    }
}
