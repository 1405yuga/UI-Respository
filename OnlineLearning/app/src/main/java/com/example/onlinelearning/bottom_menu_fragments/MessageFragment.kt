package com.example.onlinelearning.bottom_menu_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.onlinelearning.R
import com.example.onlinelearning.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private lateinit var binding: FragmentMessageBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(inflater,container,false)
        val navHost = childFragmentManager.findFragmentById(binding.messageFragmentContainer.id) as NavHostFragment
        navController = navHost.navController

        binding.apply {
            messageTextView.setTextColor(ContextCompat.getColor(requireContext(),R.color.message_selected_text))
            notificationTextView.setTextColor(ContextCompat.getColor(requireContext(),R.color.message_unselected_text))
            messageBar.visibility = View.VISIBLE
            notificationBar.visibility=View.INVISIBLE
            navController.navigate(R.id.messageMessageFragment)

            messageLayout.setOnClickListener {
                messageTextView.setTextColor(ContextCompat.getColor(requireContext(),R.color.message_selected_text))
                notificationTextView.setTextColor(ContextCompat.getColor(requireContext(),R.color.message_unselected_text))
                messageBar.visibility = View.VISIBLE
                notificationBar.visibility=View.INVISIBLE
                navController.navigate(R.id.messageMessageFragment)
            }
            notificationLayout.setOnClickListener {
                notificationTextView.setTextColor(ContextCompat.getColor(requireContext(),R.color.message_selected_text))
                messageTextView.setTextColor(ContextCompat.getColor(requireContext(),R.color.message_unselected_text))
                messageBar.visibility = View.INVISIBLE
                notificationBar.visibility=View.VISIBLE
                navController.navigate(R.id.messageNotificationFragment)
            }
        }

        return binding.root
    }

}