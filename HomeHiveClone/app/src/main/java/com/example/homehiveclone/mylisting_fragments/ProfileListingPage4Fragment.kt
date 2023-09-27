package com.example.homehiveclone.mylisting_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentProfileListingPage2Binding
import com.example.homehiveclone.databinding.FragmentProfileListingPage4Binding

class ProfileListingPage4Fragment : Fragment() {

    private lateinit var binding: FragmentProfileListingPage4Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListingPage4Binding.inflate(inflater,container,false)
        binding.saveButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.listingFragmentContainer,ProfileListingPage5Fragment())
                .addToBackStack(null)
                .commit()
        }
        binding.apply {
            smokingAllowed.setOnClickListener {
                changeToSelected(smokingAllowed)
                changeToUnSelected(smokingNotAllowed)
            }
            smokingNotAllowed.setOnClickListener {
                changeToSelected(smokingNotAllowed)
                changeToUnSelected(smokingAllowed)
            }
        }
        return binding.root
    }

    private fun changeToUnSelected(textView: TextView) {
        textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.fragment_top_bar_text))
        textView.background = ContextCompat.getDrawable(requireContext(),R.drawable.unselected_pet_button)
    }

    private fun changeToSelected(textView: TextView) {
        textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        textView.background = ContextCompat.getDrawable(requireContext(),R.drawable.selected_pet_button)
    }

}