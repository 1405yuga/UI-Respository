package com.example.onlinelearning.entryFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onlinelearning.R
import com.example.onlinelearning.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.logInButton.setOnClickListener {
            findNavController().apply {
                popBackStack(R.id.signUpFragment, true)
                navigate(R.id.logInFragment)
            }
        }
        return binding.root
    }

}