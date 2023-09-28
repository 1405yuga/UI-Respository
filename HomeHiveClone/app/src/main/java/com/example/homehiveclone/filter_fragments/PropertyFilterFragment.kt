package com.example.homehiveclone.filter_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.MainActivity
import com.example.homehiveclone.R
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
                changeToSelected(flatFilterButton)
                changeToUnSelected(tenantFilterButton)
                loadFragment(FlatFilterFragment())
            }
            tenantFilterButton.setOnClickListener {
                changeToSelected(tenantFilterButton)
                changeToUnSelected(flatFilterButton)
                loadFragment(TenantFilterFragment())
            }
        }

        binding.nextButton.setOnClickListener {
            requireActivity().finish()
        }
        return binding.root
    }

    private fun loadFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(binding.propertyFilterFragmentContainer.id, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    private fun changeToSelected(textView: TextView) {
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        textView.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(), R.color.property_filter_selected)
    }

    private fun changeToUnSelected(textView: TextView) {
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.contaced_text))
        textView.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(), R.color.property_filter_unselected)
    }

}