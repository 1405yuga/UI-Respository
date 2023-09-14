package com.example.homehiveclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.homehiveclone.databinding.ActivityProfileListingBinding
import com.example.homehiveclone.mylisting_fragments.ProfileListingPage1Fragment

class ProfileListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileListingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(ProfileListingPage1Fragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.listingFragmentContainer.id,fragment)
            .addToBackStack(null)
            .commit()
    }
}