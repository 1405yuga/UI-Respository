package com.example.homehiveclone.splash_fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homehiveclone.MainActivity
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentOnboardingThirdBinding

class OnboardingThirdFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingThirdBinding.inflate(inflater,container,false)
        binding.nextButton.setOnClickListener {
            startActivity(Intent(requireActivity(),MainActivity::class.java))
            requireActivity().finish()
        }
        return binding.root
    }

}