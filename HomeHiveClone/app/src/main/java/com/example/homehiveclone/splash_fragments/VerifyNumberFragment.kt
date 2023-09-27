package com.example.homehiveclone.splash_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentVerifyNumberBinding

class VerifyNumberFragment : Fragment() {

    private lateinit var binding: FragmentVerifyNumberBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerifyNumberBinding.inflate(inflater,container,false)

        binding.apply {
            editNumber.setOnClickListener {
                loadFragment(SignUpFragment())
            }
        }
        return binding.root
    }


    private fun loadFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.splashFragmentContainer,fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            .commit()
    }
}