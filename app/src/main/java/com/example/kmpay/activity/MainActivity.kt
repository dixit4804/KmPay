package com.example.kmpay.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.kmpay.MainFragment.CartFragment
import com.example.kmpay.MainFragment.CategoryFragment
import com.example.kmpay.MainFragment.HomeFragment
import com.example.kmpay.MainFragment.ProfileFragment
import com.example.kmpay.databinding.ActivityMainBinding
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import androidx.activity.viewModels
import com.example.kmpay.R
import com.example.kmpay.ViewModel.CartViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCartObserver()

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)

        // Add items
        bottomNavigation.add(CurvedBottomNavigation.Model(1, "Home", R.drawable.baseline_home_24))
        bottomNavigation.add(CurvedBottomNavigation.Model(2, "Category",
            R.drawable.baseline_category_24
        ))
        bottomNavigation.add(CurvedBottomNavigation.Model(3, "Cart",
            R.drawable.baseline_shopping_cart_24
        ))
        bottomNavigation.add(CurvedBottomNavigation.Model(4, "Profile",
            R.drawable.baseline_person_24
        ))

        // Set default selected item
        bottomNavigation.show(1)

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        // Correct listener to detect selected item
        bottomNavigation.setOnClickMenuListener {
            when (it.id) {
                1 -> replaceFragment(HomeFragment())
                2 -> replaceFragment(CategoryFragment())
                3 -> replaceFragment(CartFragment())
                4 -> replaceFragment(ProfileFragment())
            }
        }
    }

    private fun setupCartObserver() {
        cartViewModel.cartItems.observe(this) { items ->
            if (items.isNotEmpty()) {
                binding.bottomAppBar.visibility = View.VISIBLE
                binding.tvCartCount.text = "${items.sumOf { it.quantity }} items"

                binding.btnGoToCart.setOnClickListener {
                    navigateToCart()
                }

                // Hide after 5 seconds
                binding.bottomAppBar.postDelayed({
                    binding.bottomAppBar.visibility = View.GONE
                }, 5000)

            } else {
                binding.bottomAppBar.visibility = View.GONE
            }
        }
    }


    fun navigateToCart() {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, CartFragment())
            addToBackStack("cart")
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
        }
    }
}