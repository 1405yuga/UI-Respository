package com.example.homehiveclone.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.homehiveclone.ProfileListingActivity
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentProfileListingBinding

class ProfileListingFragment : Fragment() {

    private lateinit var binding: FragmentProfileListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileListingBinding.inflate(inflater, container, false)

        binding.listNowButton.setOnClickListener {
            startActivity(Intent(requireActivity(), ProfileListingActivity::class.java))
            Handler(Looper.getMainLooper()).postDelayed({
                binding.noListing.visibility = View.GONE
                binding.listingAdded.visibility = View.VISIBLE
            },500)
        }

        binding.yourListingText.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.home_bg_blue
            )
        )
        binding.yourListingBar.visibility = View.VISIBLE
        binding.apply {
            yourListingLayout.setOnClickListener {
                binding.yourListingText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.home_bg_blue
                    )
                )
                binding.yourListingBar.visibility = View.VISIBLE

                binding.analyticsText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.nav_menu_text
                    )
                )
                binding.analyticsBar.visibility = View.INVISIBLE
            }

            analyticsLayout.setOnClickListener {
                binding.analyticsText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.home_bg_blue
                    )
                )
                binding.analyticsBar.visibility = View.VISIBLE

                binding.yourListingText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.nav_menu_text
                    )
                )
                binding.yourListingBar.visibility = View.INVISIBLE
            }
        }

        return binding.root
    }

}