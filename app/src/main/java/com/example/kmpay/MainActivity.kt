package com.example.kmpay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kmpay.MainFragment.CartFragment
import com.example.kmpay.MainFragment.CategoryFragment
import com.example.kmpay.MainFragment.HomeFragment
import com.example.kmpay.MainFragment.ProfileFragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)

        // Add items
        bottomNavigation.add(CurvedBottomNavigation.Model(1, "Home", R.drawable.baseline_home_24))
        bottomNavigation.add(CurvedBottomNavigation.Model(2, "Category", R.drawable.baseline_category_24))
        bottomNavigation.add(CurvedBottomNavigation.Model(3, "Cart", R.drawable.baseline_shopping_cart_24))
        bottomNavigation.add(CurvedBottomNavigation.Model(4, "Profile", R.drawable.baseline_person_24))

        // Set default selected item
        bottomNavigation.show(1)
        replaceFragment(HomeFragment())

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

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
