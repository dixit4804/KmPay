package com.example.kmpay.MainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kmpay.Data.Product
import com.example.kmpay.activity.MainActivity
import com.example.kmpay.R
import com.example.kmpay.ViewModel.CartViewModel
import com.example.kmpay.databinding.FragmentProductDetailBinding

class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var product: Product
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            product = it.getParcelable("product") ?: throw IllegalStateException("Product not found")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            // Basic Product Info
            productImage.setImageResource(product.image)
            productName.text = product.name
            productPrice.text = "₹${"%.2f".format(product.price.toFloat())}"

            ratingBar.rating = product.rating
            ratingText.text = "(${(product.rating * 10).toInt()})"
            productDetails.text = product.details

            // Specifications
            product.specifications?.let { specs ->
                specsContainer.removeAllViews()
                specs.forEach { spec ->
                    val textView = TextView(requireContext()).apply {
                        text = "• $spec"
                        setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                        textSize = 14f
                        setPadding(0, 4.dpToPx(), 0, 4.dpToPx())
                    }
                    specsContainer.addView(textView)
                }
            }

            // Features
            product.features?.let { features ->
                featuresContainer.removeAllViews()
                features.forEach { feature ->
                    val textView = TextView(requireContext()).apply {
                        text = "• $feature"
                        setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                        textSize = 14f
                        setPadding(0, 4.dpToPx(), 0, 4.dpToPx())
                    }
                    featuresContainer.addView(textView)
                }
            }

            // Included Items
            product.includedItems?.let { items ->
                includedContainer.removeAllViews()
                items.forEach { item ->
                    val textView = TextView(requireContext()).apply {
                        text = "• $item"
                        setTextColor(ContextCompat.getColor(requireContext(), R.color.gray))
                        textSize = 14f
                        setPadding(0, 4.dpToPx(), 0, 4.dpToPx())
                    }
                    includedContainer.addView(textView)
                }
            }

            // Policies
            warrantyText.text = "Warranty: ${product.warranty}"
            returnPolicyText.text = "Return Policy: ${product.returnPolicy}"
            deliveryInfoText.text = "Delivery: ${product.deliveryInfo ?: "Standard shipping 3-5 days"}"

            // Button Actions - Updated with CartViewModel functionality
            addToCartButton.setOnClickListener {
                cartViewModel.addToCart(product)
                Toast.makeText(requireContext(), "${product.name} added to cart", Toast.LENGTH_SHORT).show()
            }

            buyNowButton.setOnClickListener {
                cartViewModel.addToCart(product)
                (activity as? MainActivity)?.navigateToCart() ?: run {
                    Toast.makeText(requireContext(), "Could not proceed to cart", Toast.LENGTH_SHORT).show()
                }
            }

            // Hide sections if empty
            if (product.specifications.isNullOrEmpty()) {
                specsTitle.visibility = View.GONE
                specsContainer.visibility = View.GONE
            }

            if (product.features.isNullOrEmpty()) {
                featuresTitle.visibility = View.GONE
                featuresContainer.visibility = View.GONE
            }

            if (product.includedItems.isNullOrEmpty()) {
                includedTitle.visibility = View.GONE
                includedContainer.visibility = View.GONE
            }
        }
    }

    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}