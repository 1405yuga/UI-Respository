package com.example.homehiveclone.filter_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentCityFilterBinding

class CityFilterFragment : Fragment() {

    private lateinit var binding: FragmentCityFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCityFilterBinding.inflate(inflater, container, false)
        binding.nextButton.setOnClickListener {
            loadFragment(PropertyFilterFragment())
        }
        return binding.root
    }

    private fun loadFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.filterFragmentContainer, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit()
    }
}
