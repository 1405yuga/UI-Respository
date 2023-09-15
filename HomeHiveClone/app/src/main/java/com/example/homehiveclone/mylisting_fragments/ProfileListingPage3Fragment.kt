package com.example.homehiveclone.mylisting_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentProfileListingPage3Binding


class ProfileListingPage3Fragment : Fragment() {

    private lateinit var binding: FragmentProfileListingPage3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListingPage3Binding.inflate(inflater,container,false)
        binding.saveButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.listingFragmentContainer,ProfileListingPage4Fragment())
                .addToBackStack(null)
                .commit()
        }
        return binding.root
    }

}