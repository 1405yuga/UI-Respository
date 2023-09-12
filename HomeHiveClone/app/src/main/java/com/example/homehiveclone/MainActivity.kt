package com.example.homehiveclone

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.homehiveclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.apply {
            homeLayout.setOnClickListener {
                setColorForSelectedMenu(binding.homeBar, binding.homeIcon, binding.homeText)
            }
            compareLayout.setOnClickListener {
                setColorForSelectedMenu(binding.compareBar, binding.compareIcon, binding.compareText)
            }
        }
    }

    private fun setColorForSelectedMenu(bar: ImageView, icon: ImageView, text: TextView) {
        val menuColor = ContextCompat.getColor(this, R.color.home_bg_blue)
        bar.visibility = View.VISIBLE
        text.setTextColor(menuColor)
        icon.setColorFilter(menuColor, PorterDuff.Mode.SRC_IN)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}