package com.example.kmpay.MainFragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kmpay.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ✅ Load and display name and email from SharedPreferences
        val sharedPref = requireContext().getSharedPreferences("userprofiledata", Context.MODE_PRIVATE)
        val userName = sharedPref.getString("fullname", "Guest")
        val userEmail = sharedPref.getString("email", "Not Set")

        binding.UserNameTV.text = userName
        binding.userEmailTv.text = userEmail

        // ✅ Set up click listeners for each card
        binding.card1.setOnClickListener {
            // replaceFragment(OrderHistoryFragment())
            Toast.makeText(requireContext(), "Order History clicked", Toast.LENGTH_SHORT).show()
        }

        binding.imageButton.setOnClickListener {
            replaceFragment(UserProfileFragment())
        }

        binding.card2.setOnClickListener {
            // replaceFragment(WishlistFragment())
            Toast.makeText(requireContext(), "Wishlist clicked", Toast.LENGTH_SHORT).show()
        }

        binding.card3.setOnClickListener {
            // replaceFragment(ReviewsFragment())
            Toast.makeText(requireContext(), "Reviews clicked", Toast.LENGTH_SHORT).show()
        }

        binding.card4.setOnClickListener {
            replaceFragment(SupportFragment())
        }

        binding.Addresbook.setOnClickListener {
            replaceFragment(AddressBookFragment())
        }

        binding.Notification.setOnClickListener {
            // replaceFragment(NotificationsFragment())
            Toast.makeText(requireContext(), "Notifications clicked", Toast.LENGTH_SHORT).show()
        }

        binding.Setting.setOnClickListener {
            // replaceFragment(SettingsFragment())
            Toast.makeText(requireContext(), "Settings clicked", Toast.LENGTH_SHORT).show()
        }

        binding.Aboutus.setOnClickListener {
            // replaceFragment(AboutUsFragment())
            Toast.makeText(requireContext(), "About Us clicked", Toast.LENGTH_SHORT).show()
        }

        binding.ShareApp.setOnClickListener {
            shareApp()
        }

        binding.PrivacyPolicy.setOnClickListener {
            // replaceFragment(PrivacyPolicyFragment())
            Toast.makeText(requireContext(), "Privacy Policy clicked", Toast.LENGTH_SHORT).show()
        }

        binding.LogOut.setOnClickListener {
            logout()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(id, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun shareApp() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Check out this amazing app!")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share App via"))
    }

    private fun logout() {
        // Clear user data if needed
        Toast.makeText(requireContext(), "Logged out", Toast.LENGTH_SHORT).show()
        // You could also redirect to login screen here
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
