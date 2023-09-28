package com.example.homehiveclone.filter_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentTenantFilterBinding

class TenantFilterFragment : Fragment() {

    private lateinit var binding: FragmentTenantFilterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTenantFilterBinding.inflate(inflater, container, false)
        binding.apply {
            //gender
            onlyBoys.setOnClickListener { clickedProperty(onlyBoys) }
            onlyGirls.setOnClickListener { clickedProperty(onlyGirls) }
            anyGender.setOnClickListener { clickedProperty(anyGender) }

            //profession
            student.setOnClickListener { clickedProperty(student) }
            workingProfessional.setOnClickListener { clickedProperty(workingProfessional) }
            anyProfession.setOnClickListener { clickedProperty(anyProfession) }

            //age
            below18.setOnClickListener { clickedProperty(below18) }
            age18to24.setOnClickListener { clickedProperty(age18to24) }
            age25to30.setOnClickListener { clickedProperty(age25to30) }
            age30more.setOnClickListener { clickedProperty(age30more) }

            //no pref
            drinking.setOnClickListener { clickedProperty(drinking) }
            nonVegetarian.setOnClickListener { clickedProperty(nonVegetarian) }
            smoking.setOnClickListener { clickedProperty(smoking) }
            nightShift.setOnClickListener { clickedProperty(nightShift) }
            dayShift.setOnClickListener { clickedProperty(dayShift) }

            //age
            only1.setOnClickListener { clickedProperty(only1) }
            below2.setOnClickListener { clickedProperty(below2) }
            below3.setOnClickListener { clickedProperty(below3) }
            above4.setOnClickListener { clickedProperty(above4) }
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