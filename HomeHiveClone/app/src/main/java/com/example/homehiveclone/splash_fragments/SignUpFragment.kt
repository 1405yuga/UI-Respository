package com.example.homehiveclone.splash_fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentSignUpBinding

private const val TAG = "SignUpFragment tag"

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        binding.phoneEditText.addTextChangedListener{
            if(it?.length == 10){
                binding.getOTPButton.setCardBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.activated_blue
                    )
                )
            }
            else{
                binding.getOTPButton.setCardBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.de_activated_blue
                    )
                )
            }
        }
        binding.getOTPButton.setOnClickListener {
            if(binding.phoneEditText.text.length==10){
                // TODO: go on vertification fragment
                Log.d(TAG,"Go on verification frag")
            }
        }
        return binding.root
    }

}