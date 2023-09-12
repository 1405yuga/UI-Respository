package com.example.homehiveclone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentCompareBinding

private const val TAG = "CompareFragment tag"

class CompareFragment : Fragment() {
    private lateinit var binding: FragmentCompareBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompareBinding.inflate(inflater, container, false)
        binding.propertyListText.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.home_bg_blue
            )
        )
        binding.propertyListBar.visibility = View.VISIBLE
        loadFragment(ComparePropertyListFragment())

        binding.apply {
            propertyListLayout.setOnClickListener {
                loadFragment(ComparePropertyListFragment())
                binding.propertyListText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.home_bg_blue
                    )
                )
                binding.propertyListBar.visibility = View.VISIBLE

                binding.pastResultsText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.nav_menu_text
                    )
                )
                binding.pastResultsBar.visibility = View.INVISIBLE
            }

            pastResultsLayout.setOnClickListener {
                loadFragment(ComparePastResultsFragment())
                binding.pastResultsText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.home_bg_blue
                    )
                )
                binding.pastResultsBar.visibility = View.VISIBLE

                binding.propertyListText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.nav_menu_text
                    )
                )
                binding.propertyListBar.visibility = View.INVISIBLE
            }
        }
        return binding.root
    }

    private fun loadFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(binding.compareFragmentContainer.id, fragment).setTransition(
            FragmentTransaction.TRANSIT_FRAGMENT_FADE
        ).commit()
    }

}