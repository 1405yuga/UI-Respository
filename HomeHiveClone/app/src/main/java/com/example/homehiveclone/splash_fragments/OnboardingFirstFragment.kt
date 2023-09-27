package com.example.homehiveclone.splash_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
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
                1 -> setContent(R.drawable.group_1897oboarding2,"Save your time","Compare different properties and get insightful details.",R.drawable.group_1680onboardarrow2)
                2 -> setContent(R.drawable.group_1913onboarding3,"Get end to end help","Compare different properties and get insightful details.",R.drawable.group_1680onboardarrow3)
                else -> loadFrgament(SignUpFragment())
            }
        }
        return binding.root
    }

    private fun loadFrgament(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.splashFragmentContainer,fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            .commit()
    }

    private fun setContent(image: Int, title: String, subTitle: String, button: Int){
        binding.apply {
            onBoardingImage.load(image)
            onBoardingTitle.text = title
            onBoardingSubtitle.text = subTitle
            nextButton.load(button)
        }
    }

    private fun loadActvity(){
        startActivity(Intent(requireActivity(), MainActivity::class.java))
        requireActivity().finish()
    }

}