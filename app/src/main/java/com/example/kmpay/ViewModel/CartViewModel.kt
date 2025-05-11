package com.example.kmpay.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kmpay.Data.CartItem
import com.example.kmpay.Data.Product

class CartViewModel : ViewModel() {
    private val _cartItems = MutableLiveData<List<CartItem>>(emptyList())
    val cartItems: LiveData<List<CartItem>> get() = _cartItems

    fun addToCart(product: Product) {
        val currentList = _cartItems.value?.toMutableList() ?: mutableListOf()
        val existingItem = currentList.find { it.product.id == product.id }

        if (existingItem != null) {
            existingItem.quantity++
        } else {
            currentList.add(CartItem(product))
        }

        _cartItems.value = currentList
    }

    fun updateQuantity(productId: Int, newQuantity: Int) {
        val currentList = _cartItems.value?.toMutableList() ?: return
        currentList.find { it.product.id == productId }?.let {
            it.quantity = newQuantity.coerceAtLeast(1)
            _cartItems.value = currentList
        }
    }

    fun removeItem(productId: Int) {
        val currentList = _cartItems.value?.toMutableList() ?: return
        val updatedList = currentList.filter { it.product.id != productId }
        _cartItems.value = updatedList
    }

    fun toggleSelection(productId: Int) {
        val currentList = _cartItems.value?.toMutableList() ?: return
        currentList.find { it.product.id == productId }?.let {
            it.isSelected = !it.isSelected
            _cartItems.value = currentList
        }
    }

    fun getSelectedItems() = _cartItems.value?.filter { it.isSelected } ?: emptyList()
}
