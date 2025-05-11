package com.example.kmpay.MainFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kmpay.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment() {

    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveProfileInfo.setOnClickListener {
            saveUserProfile()
        }

        binding.btnDeleteAccount.setOnClickListener {
            deleteUserProfile()
        }

        loadUserProfile()
    }

    private fun saveUserProfile() {
        val fullName = binding.textInputEditText.text.toString().trim()
        val email = binding.textInputEditTextemail.text.toString().trim()

        if (fullName.isEmpty() || email.isEmpty()) {
            Toast.makeText(
                requireContext(),
                "Name and Email are required to save the profile.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val sharedPref = requireContext().getSharedPreferences("userprofiledata", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("fullname", fullName)
            putString("email", email)
            putString("mobile", binding.textInputEditTextmobilenumber.text.toString())
            putString("altmobile", binding.textInputEditTextmobilenumberalt.text.toString())
            apply()
        }

        Toast.makeText(requireContext(), "Profile saved", Toast.LENGTH_SHORT).show()
    }


    private fun loadUserProfile() {
        val sharedPref = requireContext().getSharedPreferences("userprofiledata", Context.MODE_PRIVATE)
        binding.textInputEditText.setText(sharedPref.getString("fullname", ""))
        binding.textInputEditTextemail.setText(sharedPref.getString("email", ""))
        binding.textInputEditTextmobilenumber.setText(sharedPref.getString("mobile", ""))
        binding.textInputEditTextmobilenumberalt.setText(sharedPref.getString("altmobile", ""))
    }
    private fun deleteUserProfile() {
        val fullName = binding.textInputEditText.text.toString().trim()
        val email = binding.textInputEditTextemail.text.toString().trim()

//        if (fullName.isEmpty() || email.isEmpty()) {
//            Toast.makeText(
//                requireContext(),
//                "Name and Email are required to request account deletion.",
//                Toast.LENGTH_SHORT
//            ).show()
//            return
//        }

        androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setTitle("Confirm Deletion")
            .setMessage("Are you sure you want to delete your account?")
            .setPositiveButton("Yes") { dialog, _ ->
                val sharedPref = requireContext().getSharedPreferences("userprofiledata", Context.MODE_PRIVATE)
                sharedPref.edit().clear().apply()

                binding.textInputEditText.setText("")
                binding.textInputEditTextemail.setText("")
                binding.textInputEditTextmobilenumber.setText("")
                binding.textInputEditTextmobilenumberalt.setText("")

                Toast.makeText(requireContext(), "Profile data deleted", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
