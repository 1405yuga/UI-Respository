package com.example.homehiveclone.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.R
import com.example.homehiveclone.constants.ProjectConstants
import com.example.homehiveclone.databinding.FragmentActivityBinding

private const val TAG = "ActivityFragment tag"

class ActivityFragment : Fragment() {
    private lateinit var binding: FragmentActivityBinding
    var currMenuSelected = ProjectConstants.RECENT_SEARCH_MENU
    var prevMenuSelected = ProjectConstants.NONE

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActivityBinding.inflate(inflater, container, false)

        binding.apply {
            recentSearchLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.RECENT_SEARCH_MENU)
            }
            contactedLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.CONTACTED_MENU)
            }
            sharedLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.SHARED_MENU)
            }
            viewedLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.VIEWED_MENU)
            }
        }
        return binding.root
    }

    private fun setMenuSelected(menu: String) {
        if (menu != currMenuSelected) {
            prevMenuSelected = currMenuSelected
            currMenuSelected = menu
            Log.d(TAG, "CurrentMenu: $currMenuSelected PrevMenu :$prevMenuSelected")
            setPrevMenuUnselected(prevMenuSelected)
            currMenuSelected(currMenuSelected)
        }
    }

    private fun currMenuSelected(currMenu: String) {
        when (currMenu) {
            ProjectConstants.RECENT_SEARCH_MENU -> {
                setColorForSelectedMenu(binding.recentSearchBar, binding.recentSearchText)
                loadFragment(ActivityRecentSearchFragment())
            }

            ProjectConstants.CONTACTED_MENU -> {
                setColorForSelectedMenu(binding.contactedBar, binding.contactedText)
                loadFragment(ActvityContactedFragment())
            }

            ProjectConstants.SHARED_MENU -> {
                setColorForSelectedMenu(binding.sharedBar, binding.sharedText)
                loadFragment(AcitivitySharedFragment())
            }

            ProjectConstants.VIEWED_MENU -> {
                setColorForSelectedMenu(binding.viewedBar, binding.viewedText)
                loadFragment(ActivityViewedFragment())
            }
        }

    }

    private fun setPrevMenuUnselected(prevMenu: String) {
        when (prevMenu) {
            ProjectConstants.RECENT_SEARCH_MENU -> {
                setColorForUnselectedMenu(binding.recentSearchBar, binding.recentSearchText)
            }

            ProjectConstants.CONTACTED_MENU -> {
                setColorForUnselectedMenu(binding.contactedBar, binding.contactedText)
            }

            ProjectConstants.SHARED_MENU -> {
                setColorForUnselectedMenu(binding.sharedBar, binding.sharedText)
            }

            ProjectConstants.VIEWED_MENU -> {
                setColorForUnselectedMenu(binding.viewedBar, binding.viewedText)
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(binding.activityFragmentContainer.id, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    private fun setColorForUnselectedMenu(bar: ImageView, text: TextView) {
        val menuColor = ContextCompat.getColor(requireContext(), R.color.bottom_menu)
        bar.visibility = View.INVISIBLE
        text.setTextColor(menuColor)
    }

    private fun setColorForSelectedMenu(bar: ImageView, text: TextView) {
        val menuColor = ContextCompat.getColor(requireContext(), R.color.home_bg_blue)
        bar.visibility = View.VISIBLE
        text.setTextColor(menuColor)
    }

}