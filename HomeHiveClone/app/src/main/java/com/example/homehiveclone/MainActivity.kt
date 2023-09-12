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
import com.example.homehiveclone.fragments.CompareFragment
import com.example.homehiveclone.fragments.HomeFragment

private  const val TAG = " tag"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var currMenuSelected = ProjectConstants.HOME_MENU
    lateinit var prevMenuSelected : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())
        binding.apply {
            homeLayout.setOnClickListener {
                setMenuSelected(ProjectConstants.HOME_MENU)
                loadFragment(HomeFragment())
                setColorForSelectedMenu(binding.homeBar, binding.homeIcon, binding.homeText)
            }
            compareLayout.setOnClickListener {
                loadFragment(CompareFragment())
                setColorForSelectedMenu(
                    binding.compareBar,
                    binding.compareIcon,
                    binding.compareText
                )
            }
            binding.savedLayout.setOnClickListener {
                prevMenuSelected = currMenuSelected
                currMenuSelected = ProjectConstants.SAVED_MENU
                Log.d(TAG,"currennt : $currMenuSelected prev:$prevMenuSelected")
            }
        }
    }

    private fun setMenuSelected(menu: String) {
        if(prevMenuSelected!=currMenuSelected){
            prevMenuSelected = currMenuSelected
            currMenuSelected = menu
        }

    }


    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.navHostFragment.id, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    private fun setColorForSelectedMenu(bar: ImageView, icon: ImageView, text: TextView) {
        val menuColor = ContextCompat.getColor(this, R.color.home_bg_blue)
        bar.visibility = View.VISIBLE
        text.setTextColor(menuColor)
        icon.setColorFilter(menuColor, PorterDuff.Mode.SRC_IN)
    }

}