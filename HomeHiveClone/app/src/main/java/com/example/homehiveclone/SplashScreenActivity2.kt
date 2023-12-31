package com.example.homehiveclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.homehiveclone.databinding.ActivitySplashScreen2Binding

class SplashScreenActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreen2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //splash screen
        Handler(Looper.getMainLooper()).postDelayed({ finish()},2000)
    }
}