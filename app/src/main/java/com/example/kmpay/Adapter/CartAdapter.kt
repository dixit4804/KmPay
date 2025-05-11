package com.example.kmpay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kmpay.Data.CartItem
import com.example.kmpay.databinding.ItemCartBinding
import java.text.NumberFormat
import java.util.Locale

class CartAdapter(
    private val onQuantityChanged: (CartItem, Int) -> Unit,
    private val onRemoveItem: (CartItem) -> Unit
) : ListAdapter<CartItem, CartAdapter.CartViewHolder>(CartDiffCallback()) {

    private val currencyFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN")).apply {
        maximumFractionDigits = 2
        minimumFractionDigits = 2
    }

    private var currentItems = listOf<CartItem>()
        private set

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: List<CartItem>?) {
        currentItems = list ?: emptyList()
        super.submitList(list?.let { ArrayList(it) })
    }

    fun updateItemQuantity(productId: Int, newQuantity: Int) {
        val position = currentItems.indexOfFirst { it.product.id == productId }
        if (position != -1) {
            val updatedItem = currentItems[position].copy(quantity = newQuantity)
            val newList = currentItems.toMutableList().apply {
                set(position, updatedItem)
            }
            submitList(newList)
        }
    }

    inner class CartViewHolder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cartItem: CartItem) {
            with(binding) {
                // Bind product data with proper price formatting
                productName.text = cartItem.product.name
                productPrice.text = formatPrice(cartItem.product.price)
                productQuantity.text = cartItem.quantity.toString()

                // Quantity controls
                btnIncrease.setOnClickListener {
                    val newQuantity = cartItem.quantity + 1
                    updateQuantityDisplay(newQuantity)
                    onQuantityChanged(cartItem, newQuantity)
                }

                btnDecrease.setOnClickListener {
                    if (cartItem.quantity > 1) {
                        val newQuantity = cartItem.quantity - 1
                        updateQuantityDisplay(newQuantity)
                        onQuantityChanged(cartItem, newQuantity)
                    }
                }

                btnRemove.setOnClickListener {
                    onRemoveItem(cartItem)
                }
            }
        }

        private fun updateQuantityDisplay(newQuantity: Int) {
            binding.productQuantity.text = newQuantity.toString()
        }
    }

    private fun formatPrice(price: Number): String {
        return try {
            currencyFormat.format(price.toDouble())
        } catch (e: Exception) {
            "₹${price}" // Fallback formatting
        }
    }

    class CartDiffCallback : DiffUtil.ItemCallback<CartItem>() {
        override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            return oldItem.product.id == newItem.product.id
        }

        override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean {
            return oldItem == newItem
        }
    }
}