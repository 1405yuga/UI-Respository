package com.example.onlinelearning.entryFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import coil.load
import com.example.onlinelearning.R
import com.example.onlinelearning.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {

    private var click = 0
    private lateinit var binding : FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater,container,false)

        binding.nextBar.setOnClickListener {
            click+=1
            when(click){
                1 -> setNewOnBoarding(R.drawable.illustration_02,"Quick and easy \n learning","Easy and fast learning at \nany time to help you \n improve various skills",R.drawable.pavigation2)
                2 -> {
                    binding.skipButton.visibility = View.INVISIBLE
                    setNewOnBoarding(R.drawable.illustration_03,"Create your own \nstudy plan","Study according to the \nstudy plan, make study \nmore motivated",R.drawable.pavigation3)
                }
                // TODO: load fragment
            }
        }

        return binding.root
    }

    private fun setNewOnBoarding(image: Int, title: String, subtitle: String, nextButton: Int) {
        binding.apply {
            onBoardingImage.load(image){
                placeholder(image)
            }
            onBoardingTitle.text = title
            onBoardingSubtitle.text = subtitle
            nextBar.load(nextButton){
                placeholder(nextButton)
            }
        }

    }

}