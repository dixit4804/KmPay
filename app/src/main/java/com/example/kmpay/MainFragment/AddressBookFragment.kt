package com.example.kmpay.MainFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kmpay.R
import com.example.kmpay.databinding.FragmentAddressBookBinding

class AddressBookFragment : Fragment() {

    private var _binding: FragmentAddressBookBinding? = null
    private val binding get() = _binding!!

    // SharedPreferences for saving data
    private val sharedPref by lazy {
        requireActivity().getSharedPreferences("AddressBookData", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using ViewBinding
        _binding = FragmentAddressBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the button click listener
        binding.buttonLogin.setOnClickListener {
            saveAddressBookData()
        }
    }

    private fun saveAddressBookData() {
        val fullName = binding.textInputEditText.text.toString()
        val mobileNo = binding.textInputEditText2.text.toString()
        val pinCode = binding.textInputEditText3.text.toString()
        val state = binding.textInputEditText4.text.toString()
        val city = binding.textInputEditText5.text.toString()
        val houseNo = binding.textInputEditText6.text.toString()
        val area = binding.textInputEditText7.text.toString()
        val landmark = binding.textInputEditText8.text.toString()

        // Get the selected radio button (Home or Office)
        val addressType = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radiohome -> "Home"
            R.id.radioofice -> "Office"
            else -> ""
        }

        // Save data to SharedPreferences
        val editor = sharedPref.edit()
        editor.putString("FullName", fullName)
        editor.putString("MobileNo", mobileNo)
        editor.putString("PinCode", pinCode)
        editor.putString("State", state)
        editor.putString("City", city)
        editor.putString("HouseNo", houseNo)
        editor.putString("Area", area)
        editor.putString("Landmark", landmark)
        editor.putString("AddressType", addressType)  // Save the selected address type
        editor.apply()

        // Show Toast message
        Toast.makeText(requireContext(), "Data Saved Successfully!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
