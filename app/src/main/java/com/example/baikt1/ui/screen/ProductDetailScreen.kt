package com.example.baikt1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.baikt1.R
import com.example.baikt1.data.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(productId: Int, onBackClick: () -> Unit) {
    // Danh sách sản phẩm mẫu
    val products = listOf(
        Product(
            1,
            "DANVOUY Womens T Shirt",
            "Đây là một chiếc áo thun của thương hiệu DANVOUY, được làm từ chất liệu 95% cotton và 5% spandex ",
            12.99,
            R.drawable.ao_thun,
            4.5
        ),
        Product(
            2,
            "Opna Women's Short Sleeve",
            "100% Polyester, Machine Wash",
            7.95,
            R.drawable.ao_thun2,
            4.0
        ),
        Product(
            3,
            "MBJ Women's Solid Short",
            "95% Rayon, Made in USA",
            9.85,
            R.drawable.ao_thun3,
            4.6
        ),
        Product(
            4,
            "Rain Jacket Women",
            "Lightweight, waterproof, stylish",
            39.99,
            R.drawable.ao_khoac_mua,
            0.0
        ),
        Product(
            5,
            "Jacket Women",
            "Áo khoác sành điệu vừa giữ ấm cho cơ thể vừa tạo sự sang trọng cho người mặc",
            28.98,
            R.drawable.ao_khoac,
            0.0
        ),

    )

    // Tìm sản phẩm theo productId
    val product = products.find { it.id == productId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "  ") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(0xFFC7CDD0))
            )
        },
        bottomBar = {
            if (product != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .padding(bottom = 30.dp)
                        .background(Color.White),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = " $${product.price}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        color = Color(0xFF090909)
                    )
                    Button(
                        onClick = { /* Thêm vào giỏ hàng */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF313D7A))
                    ) {
                        Text(text = "ADD TO CART", fontSize = 18.sp)
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            if (product != null) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Text(
                            text = product.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 26.sp,
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "⭐ ${product.rating} / 5.0",
                            fontSize = 18.sp,
                            color = Color(0xFFFFA000),
                            modifier = Modifier.fillMaxWidth(),
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Image(
                            painter = painterResource(id = product.imageRes),
                            contentDescription = "Ảnh sản phẩm",
                            modifier = Modifier
                                .size(400.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = product.description,
                            fontSize = 16.sp,
                            color = Color.Gray,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(80.dp)) // Để tránh bị che bởi bottomBar
                    }
                }
            } else {
                Text(
                    text = "Sản phẩm không tồn tại",
                    fontSize = 18.sp,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

