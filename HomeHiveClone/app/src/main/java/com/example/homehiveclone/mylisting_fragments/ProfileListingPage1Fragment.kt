package com.example.homehiveclone.mylisting_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentProfileListingPage1Binding

private const val TAG = "ProfileListingPage1Fragment tag"

class ProfileListingPage1Fragment : Fragment() {

    private lateinit var binding: FragmentProfileListingPage1Binding
    private val cityNames = arrayOf("Mumbai City","Mumbai Suburban","Delhi","Kolkata","Punjab")
    private val localityNames = arrayOf("Andheri","Bandra","Borivali","Goregaon")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListingPage1Binding.inflate(inflater,container,false)
        binding.saveButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.listingFragmentContainer,ProfileListingPage2Fragment())
                .addToBackStack(null)
                .commit()
        }

        binding.apply {
            setEditTextAdapters(cityNameEditText,cityNames,cityNameDropDown)
            setEditTextAdapters(localityEditText,localityNames,localityDropDown)
        }
        return binding.root
    }

    private fun setEditTextAdapters(
        editText: AutoCompleteTextView,
        dropDownArray: Array<String>,
        dropDownButton: ImageView
    ) {
        editText.setAdapter(ArrayAdapter(requireContext(), androidx.transition.R.layout.support_simple_spinner_dropdown_item,dropDownArray))
        editText.threshold = 1
        editText.setOnItemClickListener { adapterView, view, i, l ->
            val temp = adapterView.getItemAtPosition(i).toString()
            Log.d(TAG , "Selected text : $temp")
            dropDownButton.visibility = View.GONE
        }
    }

}