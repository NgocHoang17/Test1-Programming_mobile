package com.example.baikt1.data
import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    @DrawableRes val imageRes: Int, // ID hình ảnh trong drawable
    val rating: Double  // Điểm đánh giá sao
)
