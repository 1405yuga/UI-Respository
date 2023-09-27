package com.example.homehiveclone.splash_fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homehiveclone.MainActivity
import com.example.homehiveclone.R


class OnBoardingDoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Handler(Looper.getMainLooper()).postDelayed({loadActivity()},1000)
        return inflater.inflate(R.layout.fragment_on_boarding_done, container, false)
    }

    private fun loadActivity(){
        startActivity(Intent(requireActivity(), MainActivity::class.java))
        requireActivity().finish()
    }
}