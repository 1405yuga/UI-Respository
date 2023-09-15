package com.example.homehiveclone.mylisting_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }

}