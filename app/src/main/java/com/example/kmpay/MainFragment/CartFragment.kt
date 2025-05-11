package com.example.kmpay.MainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kmpay.Data.CartItem
import com.example.kmpay.R
import com.example.kmpay.ViewModel.CartViewModel
import com.example.kmpay.adapters.CartAdapter
import com.example.kmpay.databinding.FragmentCartBinding
import java.text.NumberFormat
import java.util.Locale

class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private val cartViewModel: CartViewModel by activityViewModels()
    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        cartAdapter = CartAdapter(
            onQuantityChanged = { cartItem, newQuantity ->
                // Update ViewModel first
                cartViewModel.updateQuantity(cartItem.product.id, newQuantity)
                // Then update local quantity display immediately
                cartAdapter.updateItemQuantity(cartItem.product.id, newQuantity)
            },
            onRemoveItem = { cartItem ->
                cartViewModel.removeItem(cartItem.product.id)
            }
        )

        binding.rvCartItems.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cartAdapter
            setHasFixedSize(true)
        }
    }

    private fun setupObservers() {
        cartViewModel.cartItems.observe(viewLifecycleOwner) { cartItems ->
            cartAdapter.submitList(cartItems)
            updateTotal()
        }
    }

    private fun updateTotal() {
        val total = cartViewModel.cartItems.value?.sumOf {
            it.product.price * it.quantity
        } ?: 0.0

        val formattedTotal = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
            .format(total)
            .replace("₹", "₹ ")
        binding.tvTotal.text = getString(R.string.total_price_format, formattedTotal)
    }



    private fun setupClickListeners() {
        binding.btnBuyNow.setOnClickListener {
            val cartItems = cartViewModel.cartItems.value
            if (cartItems.isNullOrEmpty()) {
                binding.tvTotal.text = getString(R.string.cart_empty_message)
            } else {
                // Calculate total again here
                val total = cartItems.sumOf { it.product.price * it.quantity }

                val checkoutFragment = CheckOutFragment()
                val bundle = Bundle().apply {
                    putDouble("total_amount", total.toDouble())
                }
                checkoutFragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, checkoutFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}