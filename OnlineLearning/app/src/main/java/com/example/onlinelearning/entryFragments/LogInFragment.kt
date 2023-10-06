package com.example.onlinelearning.entryFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onlinelearning.MainActivity2
import com.example.onlinelearning.R
import com.example.onlinelearning.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater, container, false)

        binding.apply {
            signUpButton.setOnClickListener {
                findNavController().apply {
                    popBackStack(R.id.logInFragment, true)
                    navigate(R.id.signUpFragment)
                }
            }

            logInButton.setOnClickListener {
                startActivity(Intent(requireActivity(),MainActivity2::class.java))
                requireActivity().finish()
            }
        }

        return binding.root
    }

}