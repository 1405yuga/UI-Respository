package com.example.onlinelearning.bottom_menu_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
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
    ): View {

        binding = FragmentMessageBinding.inflate(inflater, container, false)
        val selectedMenuText =
            ContextCompat.getColor(requireContext(), R.color.message_selected_text)
        val unselectedMenuText =
            ContextCompat.getColor(requireContext(), R.color.message_unselected_text)

        val navHost =
            childFragmentManager.findFragmentById(binding.messageFragmentContainer.id) as NavHostFragment
        navController = navHost.navController

        val choice = MutableLiveData(MessageChoices.MESSAGE)

        choice.observe(viewLifecycleOwner) {
            binding.apply {
                messageTextView.setTextColor(if (it == MessageChoices.MESSAGE) selectedMenuText else unselectedMenuText)
                messageBar.visibility =
                    (if (it == MessageChoices.MESSAGE) View.VISIBLE else View.INVISIBLE)

                notificationTextView.setTextColor(if (it == MessageChoices.NOTIFICATION) selectedMenuText else unselectedMenuText)
                notificationBar.visibility =
                    (if (it == MessageChoices.NOTIFICATION) View.VISIBLE else View.INVISIBLE)

                navController.navigate(if (it == MessageChoices.MESSAGE) R.id.messageMessageFragment else R.id.messageNotificationFragment)
            }
        }

        binding.apply {
            messageLayout.setOnClickListener {
                choice.value = MessageChoices.MESSAGE

            }
            notificationLayout.setOnClickListener {
                choice.value = MessageChoices.NOTIFICATION
            }
        }
        return binding.root
    }
}

private enum class MessageChoices {
    MESSAGE, NOTIFICATION
}