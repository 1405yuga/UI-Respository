package com.example.onlinelearning.entryFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinelearning.R
import com.example.onlinelearning.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        binding.logInButton.setOnClickListener {
            findNavController().navigate(R.id.logInFragment)
        }
        return binding.root
    }

}