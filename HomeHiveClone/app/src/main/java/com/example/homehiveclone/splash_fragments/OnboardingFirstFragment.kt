package com.example.homehiveclone.splash_fragments

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.homehiveclone.MainActivity
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentOnboardingFirstBinding

class OnboardingFirstFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingFirstBinding
    private var clickCount = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingFirstBinding.inflate(inflater, container, false)

        binding.nextButton.setOnClickListener {
            clickCount+=1
            when(clickCount){
                1 -> setContent(R.drawable.group_1897oboarding2,"Save your time","Compare different properties and get insightful details.")
                2 -> setContent(R.drawable.group_1913onboarding3,"Get end to end help","Compare different properties and get insightful details.")
                else -> loadActvity()
            }
        }
        return binding.root
    }

    private fun setContent(image: Int, title: String, subTitle: String){
        binding.apply {
            onBoardingImage.load(image)
            onBoardingTitle.text = title
            onBoardingSubtitle.text = subTitle
        }
    }

    private fun loadActvity(){
        startActivity(Intent(requireActivity(), MainActivity::class.java))
        requireActivity().finish()
    }

}