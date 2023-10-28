package com.example.onlinelearning

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.onlinelearning.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHost.navController
        val selectedMenuColor = ContextCompat.getColor(this, R.color.sign_up_button_bg)
        val unselectedMenuColor =
            ContextCompat.getColor(this, R.color.bottom_navigation_unselected_menu_text)

        val selectedMenuIcon = ContextCompat.getColor(this, R.color.sign_up_button_bg)
        val unselectedMenuIcon =
            ContextCompat.getColor(this, R.color.bottom_navigation_unselected_menu_icon)

        val choice = MutableLiveData(Menus.HOME)

        binding.apply {
            homeLayout.setOnClickListener { choice.value = Menus.HOME }
            courseLayout.setOnClickListener { choice.value = Menus.COURSE }
            messageLayout.setOnClickListener { choice.value = Menus.MESSAGE }
            accountLayout.setOnClickListener { choice.value = Menus.ACCOUNT }
        }

        choice.observe(this) {
            binding.apply {
                homeText.setTextColor(if (it == Menus.HOME) selectedMenuColor else unselectedMenuColor)
                courseText.setTextColor(if (it == Menus.COURSE) selectedMenuColor else unselectedMenuColor)
                messageText.setTextColor(if (it == Menus.MESSAGE) selectedMenuColor else unselectedMenuColor)
                accountText.setTextColor(if (it == Menus.ACCOUNT) selectedMenuColor else unselectedMenuColor)

                homeIcon.setColorFilter(
                    if (it == Menus.HOME) selectedMenuIcon else unselectedMenuIcon,
                    PorterDuff.Mode.SRC_IN
                )
                courseIcon.setColorFilter(
                    if (it == Menus.COURSE) selectedMenuIcon else unselectedMenuIcon,
                    PorterDuff.Mode.SRC_IN
                )
                messageIcon.setColorFilter(
                    if (it == Menus.MESSAGE) selectedMenuIcon else unselectedMenuIcon,
                    PorterDuff.Mode.SRC_IN
                )
                accountIcon.setColorFilter(
                    if (it == Menus.ACCOUNT) selectedMenuIcon else unselectedMenuIcon,
                    PorterDuff.Mode.SRC_IN
                )

                homeBar.visibility = (if (it == Menus.HOME) View.VISIBLE else View.INVISIBLE)
                courseBar.visibility = (if (it == Menus.COURSE) View.VISIBLE else View.INVISIBLE)
                messageBar.visibility = (if (it == Menus.MESSAGE) View.VISIBLE else View.INVISIBLE)
                accountBar.visibility = (if (it == Menus.ACCOUNT) View.VISIBLE else View.INVISIBLE)

                navController.navigate(
                    when (it) {
                        Menus.HOME -> R.id.homeFragment
                        Menus.COURSE -> R.id.courseFragment
                        Menus.MESSAGE -> R.id.messageFragment
                        else -> R.id.accountFragment
                    }
                )

            }
        }

    }
}

private enum class Menus {
    HOME, COURSE, MESSAGE, ACCOUNT
}