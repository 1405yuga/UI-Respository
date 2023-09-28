package com.example.homehiveclone.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homehiveclone.FilterActivity
import com.example.homehiveclone.MainActivity
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.searchCardView.setOnClickListener {
            startActivity(Intent(requireActivity(), FilterActivity::class.java))
        }
        return binding.root
    }

}