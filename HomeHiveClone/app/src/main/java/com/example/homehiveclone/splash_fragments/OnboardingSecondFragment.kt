package com.example.homehiveclone.splash_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentOnboardingFirstBinding
import com.example.homehiveclone.databinding.FragmentOnboardingSecondBinding

class OnboardingSecondFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentOnboardingSecondBinding.inflate(inflater,container,false)
        binding.nextButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.splashFragmentContainer,OnboardingThirdFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                .commit()
        }
        return binding.root
    }

}