package com.example.homehiveclone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.homehiveclone.R
import com.example.homehiveclone.databinding.FragmentComparePropertyListBinding

private const val TAG = "ComparePropertyListFragment tag"

class ComparePropertyListFragment : Fragment() {

    private lateinit var binding: FragmentComparePropertyListBinding
    val checkbtnIsChecked = mutableListOf(false, false, false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComparePropertyListBinding.inflate(inflater, container, false)

        binding.apply {
            checkbtn1.setOnClickListener {
                checkbtnIsChecked.add(0, !checkbtnIsChecked.get(0))
                updateCheckBox(checkbtn1, checkbtnIsChecked.get(0))
            }

            checkbtn2.setOnClickListener {
                checkbtnIsChecked.add(1, !checkbtnIsChecked.get(1))
                updateCheckBox(checkbtn2, checkbtnIsChecked.get(1))
            }
            checkbtn3.setOnClickListener {
                checkbtnIsChecked.add(2, !checkbtnIsChecked.get(2))
                updateCheckBox(checkbtn3, checkbtnIsChecked.get(2))
            }

        }
        return binding.root
    }

    private fun updateCheckBox(checkbtn: ImageView, checkbtnIsChecked: Boolean) {
        val image_id = if (checkbtnIsChecked == true) R.drawable.rectangle_317
        else R.drawable.check_button

        checkbtn.setImageResource(image_id)

    }

}