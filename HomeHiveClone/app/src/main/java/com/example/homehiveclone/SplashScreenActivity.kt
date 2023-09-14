package com.example.homehiveclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.homehiveclone.splash_fragments.SplashFirstFragment

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        loadFrgament(SplashFirstFragment())
    }

    private fun loadFrgament(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.splashFragmentContainer,fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            .commit()
    }
}