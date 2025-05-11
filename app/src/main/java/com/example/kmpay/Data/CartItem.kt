package com.example.kmpay.Data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CartItem(
    val product: Product,
    var quantity: Int = 1,
    var isSelected: Boolean = true
) : Parcelable