package com.example.onlinelearning.bottom_menu_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.example.onlinelearning.R
import com.example.onlinelearning.databinding.FragmentCourseBinding

class CourseFragment : Fragment() {

    private lateinit var binding: FragmentCourseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseBinding.inflate(inflater, container, false)
        val selectedMenuText = ContextCompat.getColor(requireContext(), R.color.white)
        val unselectedMenuText =
            ContextCompat.getColor(requireContext(), R.color.course_type_unselected_text)
        val selectedMenuTint = ContextCompat.getColor(requireContext(), R.color.sign_up_button_bg)
        val unselectedMenuTint =
            ContextCompat.getColor(requireContext(), R.color.course_type_unselected_bg)

        val choice = MutableLiveData(CourseTypes.ALL)

        choice.observe(viewLifecycleOwner) {
            binding.apply {
                allCourseType.apply {
                    setTextColor(if (it == CourseTypes.ALL) selectedMenuText else unselectedMenuText)
                    background.setTint(if (it == CourseTypes.ALL) selectedMenuTint else unselectedMenuTint)
                }

                popularCourseType.apply {
                    setTextColor(if (it == CourseTypes.POPULAR) selectedMenuText else unselectedMenuText)
                    background.setTint(if(it == CourseTypes.POPULAR) selectedMenuTint else unselectedMenuTint)
                }

                newCourseType.apply {
                    setTextColor(if (it == CourseTypes.NEW) selectedMenuText else unselectedMenuText)
                    background.setTint(if(it == CourseTypes.NEW) selectedMenuTint else unselectedMenuTint)
                }

            }
        }

        binding.apply {

            allCourseType.setOnClickListener {
                choice.value = CourseTypes.ALL
            }
            popularCourseType.setOnClickListener {
                choice.value = CourseTypes.POPULAR

            }
            newCourseType.setOnClickListener {
                choice.value = CourseTypes.NEW
            }
        }
        return binding.root
    }

}

private enum class CourseTypes {
    ALL, POPULAR, NEW
}