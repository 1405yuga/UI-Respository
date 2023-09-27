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
    private val bhkTypes = arrayOf("1 BHK","2 BHK","3 BHK",)
    private val roomTypes = arrayOf("Private room","Sharing room")
    private val furnishingLevel = arrayOf("Fully furnished","Semi furnished","Unfurnished")

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
            setEditTextAdapters(cityNameEditText,cityNames,cityNameDropDown,false)
            setEditTextAdapters(localityEditText, localityNames, localityDropDown, false)
            setEditTextAdapters(bhkEditText, bhkTypes, bhkDropDown, true)
            setEditTextAdapters(roomTypeEditText, roomTypes, roomTypeDropDown, true)
            setEditTextAdapters(furnishingEditText, furnishingLevel, furnishingDropDown, true)
        }
        return binding.root
    }

    private fun setEditTextAdapters(
        editText: AutoCompleteTextView,
        dropDownArray: Array<String>,
        dropDownButton: ImageView,
        showEntireList: Boolean
    ) {
        editText.setAdapter(ArrayAdapter(requireContext(), androidx.transition.R.layout.support_simple_spinner_dropdown_item,dropDownArray))
        editText.threshold = 1
        editText.setOnItemClickListener { adapterView, view, i, l ->
            val temp = adapterView.getItemAtPosition(i).toString()
            Log.d(TAG , "Selected text : $temp")
            dropDownButton.visibility = View.GONE
        }
        if(showEntireList){
            editText.setOnTouchListener { view, motionEvent ->
                editText.showDropDown()
                false
            }
        }

    }

}