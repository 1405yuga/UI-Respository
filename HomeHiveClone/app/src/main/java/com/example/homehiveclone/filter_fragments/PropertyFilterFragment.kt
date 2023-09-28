package com.example.homehiveclone.filter_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.databinding.FragmentPropertyFilterBinding

class PropertyFilterFragment : Fragment() {

    private lateinit var binding: FragmentPropertyFilterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPropertyFilterBinding.inflate(inflater, container, false)
        loadFragment(FlatFilterFragment())

        binding.apply {
            flatFilterButton.setOnClickListener {
                loadFragment(FlatFilterFragment())
            }
            tenantFilterButton.setOnClickListener { loadFragment(TenantFilterFragment()) }
        }
        return binding.root
    }

    private fun loadFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(binding.propertyFilterFragmentContainer.id, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

}