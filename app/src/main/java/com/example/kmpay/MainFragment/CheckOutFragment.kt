package com.example.kmpay.MainFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kmpay.R
import com.example.kmpay.databinding.FragmentCheckOutBinding
import java.text.NumberFormat
import java.util.*

class CheckOutFragment : Fragment() {

    private var _binding: FragmentCheckOutBinding? = null
    private val binding get() = _binding!!

    // SharedPreferences for retrieving saved address data
    private val sharedPref by lazy {
        requireActivity().getSharedPreferences("AddressBookData", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckOutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get total amount from arguments (passed as "total_amount")
        val totalAmount = arguments?.getDouble("total_amount") ?: 0.0

        // Format it to INR currency
        val formattedAmount = NumberFormat.getCurrencyInstance(Locale("en", "IN")).format(totalAmount)

        // Set it to TextView
        binding.tvTotalPayment.text = "Total Payment: $formattedAmount"

        // Retrieve address data from SharedPreferences
        val fullName = sharedPref.getString("FullName", "N/A") ?: "N/A"
        val mobileNo = sharedPref.getString("MobileNo", "N/A") ?: "N/A"
        val pinCode = sharedPref.getString("PinCode", "N/A") ?: "N/A"
        val state = sharedPref.getString("State", "N/A") ?: "N/A"
        val city = sharedPref.getString("City", "N/A") ?: "N/A"
        val houseNo = sharedPref.getString("HouseNo", "N/A") ?: "N/A"
        val area = sharedPref.getString("Area", "N/A") ?: "N/A"
        val landmark = sharedPref.getString("Landmark", "N/A") ?: "N/A"

        // Set the retrieved address data to the respective TextViews
        binding.textView5.text = fullName
        binding.textView7.text = mobileNo
        binding.textView8.text = "$area, $landmark"
        binding.textView9.text = houseNo
        binding.textView10.text = landmark
        binding.textView11.text = state
        binding.textView12.text = pinCode
        binding.textView13.text = city

        // Optional: Handle the Finish button click
        binding.btnFinish.setOnClickListener {
            // Confirmation dialog
            androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle("Confirm Order")
                .setMessage("Are you sure you want to place the order?")
                .setPositiveButton("Yes") { dialog, _ ->
                    dialog.dismiss()

                    // Inflate custom view
                    val dialogView = LayoutInflater.from(requireContext())
                        .inflate(R.layout.dialouge_orde_success, null)

                    val alertDialog = androidx.appcompat.app.AlertDialog.Builder(requireContext())
                        .setView(dialogView)
                        .setCancelable(false)
                        .create()

                    dialogView.findViewById<View>(R.id.btnOk).setOnClickListener {
                        alertDialog.dismiss()
                        // Optional: Navigate back or close
                        requireActivity().supportFragmentManager.popBackStack()
                    }

                    alertDialog.show()
                }
                .setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
