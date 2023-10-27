package com.example.onlinelearning.bottom_menu_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.onlinelearning.R
import com.example.onlinelearning.databinding.FragmentCourseBinding

class CourseFragment : Fragment() {

    private lateinit var binding: FragmentCourseBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseBinding.inflate(inflater,container,false)


        binding.apply {
            setColorForSelectedMenu(allCourseType)

            allCourseType.setOnClickListener {
                setColorForSelectedMenu(allCourseType)
                setColorForUnselectedMenu(newCourseType)
                setColorForUnselectedMenu(popularCourseType)
            }
            popularCourseType.setOnClickListener {
                setColorForSelectedMenu(popularCourseType)
                setColorForUnselectedMenu(newCourseType)
                setColorForUnselectedMenu(allCourseType)
            }
            newCourseType.setOnClickListener {
                setColorForSelectedMenu(newCourseType)
                setColorForUnselectedMenu(popularCourseType)
                setColorForUnselectedMenu(allCourseType)
            }
        }
        return binding.root
    }

    private fun setColorForUnselectedMenu(courseType: TextView) {
        courseType.setTextColor(ContextCompat.getColor(requireContext(),R.color.course_type_unselected_text))
        courseType.background.setTint(ContextCompat.getColor(requireContext(),R.color.course_type_unselected_bg))
    }

    private fun setColorForSelectedMenu(courseType: TextView) {
        courseType.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
        courseType.background.setTint(ContextCompat.getColor(requireContext(),R.color.sign_up_button_bg))
    }

}