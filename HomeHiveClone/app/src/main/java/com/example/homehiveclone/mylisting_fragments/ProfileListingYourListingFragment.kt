package com.example.homehiveclone.mylisting_fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentProfileListingYourListingBinding

class ProfileListingYourListingFragment : Fragment() {

    private lateinit var binding: FragmentProfileListingYourListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListingYourListingBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.deactiveTextView.background =
                ContextCompat.getDrawable(requireContext(),R.drawable.connect_button)

        }, 5000)

        return binding.root
    }

}