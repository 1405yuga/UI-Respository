package com.example.onlinelearning.entryFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinelearning.R
import com.example.onlinelearning.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater,container,false)

        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }

        return binding.root
    }

}