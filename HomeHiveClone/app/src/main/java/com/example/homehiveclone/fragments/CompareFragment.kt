package com.example.homehiveclone.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homehiveclone.databinding.FragmentCompareBinding

private const val TAG = "CompareFragment tag"

class CompareFragment : Fragment() {
    private lateinit var binding: FragmentCompareBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCompareBinding.inflate(inflater, container, false)
        Log.d(TAG, "onCreateView called")
        return binding.root
    }

}