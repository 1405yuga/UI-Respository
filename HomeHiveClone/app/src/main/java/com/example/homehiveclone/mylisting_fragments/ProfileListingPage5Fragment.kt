package com.example.homehiveclone.mylisting_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentProfileListingPage5Binding

class ProfileListingPage5Fragment : Fragment() {

    private lateinit var binding: FragmentProfileListingPage5Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_listing_page5, container, false)
    }

}