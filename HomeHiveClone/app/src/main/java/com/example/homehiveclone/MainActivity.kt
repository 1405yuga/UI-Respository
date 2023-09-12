package com.example.homehiveclone

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.constants.ProjectConstants
import com.example.homehiveclone.databinding.ActivityMainBinding
import com.example.homehiveclone.fragments.ActivityFragment
import com.example.homehiveclone.fragments.CompareFragment
import com.example.homehiveclone.fragments.HomeFragment
import com.example.homehiveclone.fragments.ProfileFragment
import com.example.homehiveclone.fragments.SavedFragment

private const val TAG = "MainActivity tag"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var currMenuSelected = ProjectConstants.HOME_MENU
    var prevMenuSelected = ProjectConstants.NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())
        setColorForSelectedMenu(binding.homeBar, binding.homeIcon, binding.homeText)


        binding.apply {
            homeLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.HOME_MENU)
            }
            compareLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.COMPARE_MENU)
            }
            binding.savedLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.SAVED_MENU)
            }
            binding.activityLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.ACTIVITY_MENU)
            }
            binding.profileLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.PROFILE_MENU)
            }
        }
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

    private fun currMenuSelected(menuSelected: String) {
        when (menuSelected) {
            ProjectConstants.COMPARE_MENU -> {
                setColorForSelectedMenu(
                    binding.compareBar,
                    binding.compareIcon,
                    binding.compareText
                )
                loadFragment(CompareFragment())
            }

            ProjectConstants.HOME_MENU -> {
                setColorForSelectedMenu(
                    binding.homeBar,
                    binding.homeIcon,
                    binding.homeText
                )
                loadFragment(HomeFragment())
            }

            ProjectConstants.SAVED_MENU -> {
                setColorForSelectedMenu(
                    binding.savedBar,
                    binding.savedIcon,
                    binding.savedText
                )
                loadFragment(SavedFragment())
            }

            ProjectConstants.ACTIVITY_MENU -> {
                setColorForSelectedMenu(
                    binding.activityBar,
                    binding.activityIcon,
                    binding.activityText
                )
                loadFragment(ActivityFragment())
            }

            ProjectConstants.PROFILE_MENU -> {
                setColorForSelectedMenu(
                    binding.profileBar,
                    binding.profileIcon,
                    binding.profileText
                )
                loadFragment(ProfileFragment())
            }
        }
    }

    private fun setPrevMenuUnselected(menuUnselect: String) {
        when (menuUnselect) {
            ProjectConstants.COMPARE_MENU -> setColorForUnselectedMenu(
                binding.compareBar,
                binding.compareIcon,
                binding.compareText
            )

            ProjectConstants.HOME_MENU -> setColorForUnselectedMenu(
                binding.homeBar,
                binding.homeIcon,
                binding.homeText
            )

            ProjectConstants.SAVED_MENU -> setColorForUnselectedMenu(
                binding.savedBar,
                binding.savedIcon,
                binding.savedText
            )

            ProjectConstants.ACTIVITY_MENU -> setColorForUnselectedMenu(
                    binding.activityBar,
                    binding.activityIcon,
                    binding.activityText
                )

            ProjectConstants.PROFILE_MENU -> setColorForUnselectedMenu(
                    binding.profileBar,
                    binding.profileIcon,
                    binding.profileText
                )

        }
    }


    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.navHostFragment.id, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    private fun setColorForUnselectedMenu(bar: ImageView, icon: ImageView, text: TextView) {
        val menuColor = ContextCompat.getColor(this, R.color.bottom_menu)
        bar.visibility = View.INVISIBLE
        text.setTextColor(menuColor)
        icon.setColorFilter(menuColor, PorterDuff.Mode.SRC_IN)
    }

    private fun setColorForSelectedMenu(bar: ImageView, icon: ImageView, text: TextView) {
        val menuColor = ContextCompat.getColor(this, R.color.home_bg_blue)
        bar.visibility = View.VISIBLE
        text.setTextColor(menuColor)
        icon.setColorFilter(menuColor, PorterDuff.Mode.SRC_IN)
    }

}