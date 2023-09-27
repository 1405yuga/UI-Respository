package com.example.homehiveclone.splash_fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentVerifyNumberBinding

private val TAG = "VerifyNumberFragment tag"

class VerifyNumberFragment : Fragment() {

    private lateinit var binding: FragmentVerifyNumberBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVerifyNumberBinding.inflate(inflater, container, false)

        binding.apply {
            editNumber.setOnClickListener {
                loadFragment(SignUpFragment())
            }

            otpDigit1EditText.addTextChangedListener {
                if (it?.length == 1) {
                    otpDigit2EditText.requestFocus()
                }
            }
            otpDigit2EditText.addTextChangedListener {
                if (it?.length == 1) {
                    otpDigit3EditText.requestFocus()
                }
            }
            otpDigit3EditText.addTextChangedListener {
                if (it?.length == 1) {
                    otpDigit4EditText.requestFocus()
                }
            }
            otpDigit4EditText.addTextChangedListener {
                if (it?.length == 1) {
                    binding.verifyOTPButton.setCardBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.activated_blue
                        )
                    )
                } else {
                    binding.verifyOTPButton.setCardBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.de_activated_blue
                        )
                    )
                }
            }

            verifyOTPButton.setOnClickListener {
                if (otpDigit1EditText.length() == 1 && otpDigit2EditText.length() == 1 && otpDigit3EditText.length() == 1 && otpDigit4EditText.length() == 1) {
                    // TODO: load splash fragment
                    Log.d(TAG, "Load next screen")
                }
            }
        }
        return binding.root
    }


    private fun loadFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.splashFragmentContainer, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            .commit()
    }
}