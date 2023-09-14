package com.example.homehiveclone.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homehiveclone.ProfileListingActivity
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentProfileListingBinding

class ProfileListingFragment : Fragment() {

    private lateinit var binding : FragmentProfileListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListingBinding.inflate(inflater,container,false)
        binding.listNowButton.setOnClickListener {
            startActivity(Intent(requireActivity(),ProfileListingActivity::class.java))
        }
        return binding.root
    }

}