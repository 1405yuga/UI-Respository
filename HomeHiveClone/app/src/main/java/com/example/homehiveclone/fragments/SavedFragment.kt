package com.example.homehiveclone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentSavedBinding

class SavedFragment : Fragment() {

    private lateinit var binding: FragmentSavedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedBinding.inflate(inflater,container,false)
        binding.savedPropertyText.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.home_bg_blue
            )
        )
        binding.savedPropertyBar.visibility = View.VISIBLE
        loadFragment(ComparePropertyListFragment())

        binding.apply {
            savedPropertyLayout.setOnClickListener {
                // TODO: load correct fragment
                loadFragment(ComparePropertyListFragment())
                binding.savedPropertyText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.home_bg_blue
                    )
                )
                binding.savedPropertyBar.visibility = View.VISIBLE

                binding.savedNotesText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.nav_menu_text
                    )
                )
                binding.savedNotesBar.visibility = View.INVISIBLE
            }

            savedNotesLayout.setOnClickListener {
                // TODO: load correct fragment
                loadFragment(ComparePastResultsFragment())
                binding.savedNotesText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.home_bg_blue
                    )
                )
                binding.savedNotesBar.visibility = View.VISIBLE

                binding.savedPropertyText.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.nav_menu_text
                    )
                )
                binding.savedPropertyBar.visibility = View.INVISIBLE
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