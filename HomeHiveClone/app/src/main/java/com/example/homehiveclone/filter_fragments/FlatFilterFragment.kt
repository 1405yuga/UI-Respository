package com.example.homehiveclone.filter_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentFlatFilterBinding


class FlatFilterFragment : Fragment() {

    private lateinit var binding: FragmentFlatFilterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlatFilterBinding.inflate(inflater, container, false)

        binding.apply {
            // property type
            independentHouse.setOnClickListener { clickedProperty(independentHouse) }
            apartment.setOnClickListener { clickedProperty(apartment) }
            independentFloor.setOnClickListener { clickedProperty(independentFloor) }
            villa.setOnClickListener { clickedProperty(villa) }

            // room sharing
            privateRoom.setOnClickListener { clickedProperty(privateRoom) }
            doubleSharing.setOnClickListener { clickedProperty(doubleSharing) }
            tripleSharing.setOnClickListener { clickedProperty(tripleSharing) }
            moreSharing.setOnClickListener { clickedProperty(moreSharing) }
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