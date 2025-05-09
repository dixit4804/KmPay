package com.example.kmpay.MainFragment

import ProductAdapter
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.kmpay.Adapter.ImageSliderAdapter
import com.example.kmpay.Data.Product
import com.example.kmpay.Data.ProductData
import com.example.kmpay.R
import com.example.kmpay.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var sliderAdapter: ImageSliderAdapter
    private lateinit var productAdapter: ProductAdapter
    private val handler = Handler(Looper.getMainLooper())

    private val imageList = listOf(
        R.drawable.sofa1,
        R.drawable.sofa2,
        R.drawable.kitchen1,
        R.drawable.ele1,
        R.drawable.el2
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupImageSlider()
        setupOfferPopup()
        setupProductRecyclerView() // Add this new function call
    }

    private fun setupImageSlider() {
        sliderAdapter = ImageSliderAdapter(imageList)
        with(binding.imageSlider) {
            adapter = sliderAdapter
            offscreenPageLimit = 1
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        TabLayoutMediator(binding.tabIndicator, binding.imageSlider) { _, _ -> }.attach()

        val sliderRunnable = object : Runnable {
            override fun run() {
                val current = binding.imageSlider.currentItem
                val next = (current + 1) % imageList.size
                binding.imageSlider.setCurrentItem(next, true)
                handler.postDelayed(this, 3000)
            }
        }

        handler.postDelayed(sliderRunnable, 3000)
        binding.imageSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                handler.removeCallbacksAndMessages(null)
                handler.postDelayed(sliderRunnable, 3000)
            }
        })
    }

    private fun setupOfferPopup() {
        with(binding) {
            offerContainer.visibility = View.VISIBLE
            val videoUri = Uri.parse("android.resource://${requireContext().packageName}/${R.raw.shoesoffer}")

            offerVideo.apply {
                setVideoURI(videoUri)
                setMediaController(MediaController(context).apply {
                    setAnchorView(this@apply)
                })
                start()
            }

            closeOffer.setOnClickListener {
                offerContainer.visibility = View.GONE
                offerVideo.stopPlayback()
            }

            offerVideo.setOnCompletionListener {
                offerContainer.visibility = View.GONE
            }
        }
    }
//    private fun setupProductRecyclerView() {
//        productAdapter = ProductAdapter(ProductData.productList) { product ->
//            navigateToDetailsFragment(product)

    private fun setupProductRecyclerView() {
    productAdapter = ProductAdapter(ProductData.productList) { product ->            // Handle item click - navigate to DetailsFragment
            navigateToDetailsFragment(product)
        }

        binding.productRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = productAdapter
//            addItemDecoration(GridSpacingItemDecoration(2, 16, true))
            setHasFixedSize(true)
        }
    }

    private fun navigateToDetailsFragment(product: Product) {
        val bundle = Bundle().apply {
            putParcelable("product", product)
        }

        parentFragmentManager.commit {
            replace(R.id.fragment_container, ProductDetailFragment().apply {
                arguments = bundle
            })
            addToBackStack("product_details")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null)
        _binding = null
    }
}

