package com.example.onlinelearning

import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.onlinelearning.constants.ProjectConstants
import com.example.onlinelearning.databinding.ActivityMain2Binding

private const val TAG = "MainActivity2 tag"

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private var currMenuSelected = ProjectConstants.HOME_MENU
    private var prevMenuSelected = ProjectConstants.HOME_MENU
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.navHostFragmentConatiner) as NavHostFragment
        navController = navHost.navController

        setMenuSelected(ProjectConstants.HOME_MENU)
        setColorForSelectedMenu(
            binding.homeBar,
            binding.homeIcon,
            binding.homeText,
            R.id.homeFragment
        )

        binding.apply {
            homeLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.HOME_MENU)
            }

            courseLayout.setOnClickListener { setMenuSelected(ProjectConstants.COURSE_MENU) }
            messageLayout.setOnClickListener { setMenuSelected(ProjectConstants.MESSAGE_MENU) }
            accountLayout.setOnClickListener { setMenuSelected(ProjectConstants.ACCOUNT_MENU) }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
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

    private fun setPrevMenuUnselected(menuUnselect: String) {
        when (menuUnselect) {
            ProjectConstants.HOME_MENU -> setColorForUnselectedMenu(
                binding.homeBar,
                binding.homeIcon,
                binding.homeText,
                R.id.homeFragment
            )

            ProjectConstants.COURSE_MENU -> setColorForUnselectedMenu(
                binding.courseBar,
                binding.courseIcon,
                binding.courseText,
                R.id.courseFragment
            )

            ProjectConstants.ACCOUNT_MENU -> setColorForUnselectedMenu(
                binding.accountBar,
                binding.accountIcon,
                binding.accountText,
                R.id.accountFragment
            )

            ProjectConstants.MESSAGE_MENU -> setColorForUnselectedMenu(
                binding.messageBar,
                binding.messageIcon,
                binding.messageText,
                R.id.messageFragment
            )
        }
    }


    private fun currMenuSelected(menuSelected: String) {
        when (menuSelected) {

            ProjectConstants.HOME_MENU -> {
                setColorForSelectedMenu(
                    binding.homeBar,
                    binding.homeIcon,
                    binding.homeText,
                    R.id.homeFragment
                )
            }

            ProjectConstants.COURSE_MENU -> { setColorForSelectedMenu(
                binding.courseBar,
                binding.courseIcon,
                binding.courseText,
                R.id.courseFragment
            )
            }

            ProjectConstants.ACCOUNT_MENU -> setColorForSelectedMenu(
                binding.accountBar,
                binding.accountIcon,
                binding.accountText,
                R.id.accountFragment
            )

            ProjectConstants.MESSAGE_MENU -> setColorForSelectedMenu(
                binding.messageBar,
                binding.messageIcon,
                binding.messageText,
                R.id.messageFragment
            )

        }
    }

    private fun setColorForUnselectedMenu(
        bar: ImageView,
        icon: ImageView,
        textView: TextView,
        fragmentId: Int
    ) {
        bar.visibility = View.INVISIBLE
        icon.setColorFilter(
            ContextCompat.getColor(
                this,
                R.color.bottom_navigation_unselected_menu_icon
            ), PorterDuff.Mode.SRC_IN
        )
        textView.setTextColor(
            ContextCompat.getColor(
                this,
                R.color.bottom_navigation_unselected_menu_text
            )
        )
    }


    private fun setColorForSelectedMenu(
        bar: ImageView,
        icon: ImageView,
        textView: TextView,
        fragmentId: Int
    ) {
        bar.visibility = View.VISIBLE
        val menuColor = ContextCompat.getColor(this, R.color.sign_up_button_bg)
        icon.setColorFilter(menuColor, PorterDuff.Mode.SRC_IN)
        textView.setTextColor(menuColor)
    }
}