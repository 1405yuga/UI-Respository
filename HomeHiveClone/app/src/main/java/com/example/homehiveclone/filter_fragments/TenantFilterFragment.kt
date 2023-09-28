package com.example.homehiveclone.filter_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentTenantFilterBinding

class TenantFilterFragment : Fragment() {

    private lateinit var binding: FragmentTenantFilterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTenantFilterBinding.inflate(inflater,container,false)
        binding.apply {
            //gender
            onlyBoys.setOnClickListener { clickedProperty(onlyBoys) }
            onlyGirls.setOnClickListener { clickedProperty(onlyGirls) }
            anyGender.setOnClickListener { clickedProperty(anyGender) }

            //profession
            student.setOnClickListener { clickedProperty(student) }
            workingProfessional.setOnClickListener { clickedProperty(workingProfessional) }
            anyProfession.setOnClickListener { clickedProperty(anyProfession) }
        }
        return binding.root
    }

    private fun clickedProperty(textView: TextView) {
        textView.tag = !textView.tag.toString().toBoolean()
        if (textView.tag as Boolean) {
            textView.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.selected_filter)
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
        } else {
            textView.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.unselected_filter)
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.contaced_text))
        }
    }
}