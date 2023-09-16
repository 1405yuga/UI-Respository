package com.example.homehiveclone.mylisting_fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homehiveclone.R
import com.example.homehiveclone.SplashScreenActivity2
import com.example.homehiveclone.databinding.FragmentProfileListingPage5Binding

class ProfileListingPage5Fragment : Fragment() {

    private lateinit var binding: FragmentProfileListingPage5Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListingPage5Binding.inflate(inflater,container,false)
        binding.saveButton.setOnClickListener {
            startActivity(Intent(requireActivity(),SplashScreenActivity2::class.java))
            requireActivity().finish()
        }
        return binding.root
    }

}