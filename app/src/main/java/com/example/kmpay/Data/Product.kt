package com.example.kmpay.Data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

//data class Product(
//val id: Int,
//val name: String,
//val price: Double,
//val image: Int,  // Use Int for drawable resource ID (R.drawable.xyz)
//val details: String,
//val warranty: String,
//val rating: Float
//)

//
//@Parcelize
//data class Product(
//    val id: Int,
//    val name: String,
//    val price: Double,
//    val image: Int,
//    val details: String,
//    val warranty: String,
//    val rating: Float
//) : Parcelable


@Parcelize
data class Product(
//    val product: Product,
    val id: Int,
    var quantity: Int = 1,
    val name: String,
    val price: Int,
    @DrawableRes val image: Int,
    val details: String,
    val warranty: String,
    val rating: Float,
    val specifications: List<String> = emptyList(),
    val features: List<String> = emptyList(),
    val includedItems: List<String> = emptyList(),
    val returnPolicy: String = "",
    val deliveryInfo: String = ""
) : Parcelable