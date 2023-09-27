package com.example.homehiveclone.mylisting_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentProfileListingPage2Binding
import com.example.homehiveclone.databinding.FragmentProfileListingPage3Binding

class ProfileListingPage2Fragment : Fragment() {

    private lateinit var binding: FragmentProfileListingPage2Binding
    private val maintenanceTypes = arrayOf("Included","Excluded")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListingPage2Binding.inflate(inflater,container,false)
        binding.saveButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.listingFragmentContainer,ProfileListingPage3Fragment())
                .addToBackStack(null)
                .commit()
        }

        binding.apply {
            setEditTextAdapters(maintenanceEditText,maintenanceTypes,true)
        }
        return binding.root
    }
    private fun setEditTextAdapters(
        editText: AutoCompleteTextView,
        dropDownArray: Array<String>,
        showEntireList: Boolean
    ) {
        editText.setAdapter(ArrayAdapter(requireContext(), androidx.transition.R.layout.support_simple_spinner_dropdown_item,dropDownArray))
        editText.threshold = 1
        if(showEntireList){
            editText.setOnTouchListener { view, motionEvent ->
                editText.showDropDown()
                false
            }
        }

    }

}