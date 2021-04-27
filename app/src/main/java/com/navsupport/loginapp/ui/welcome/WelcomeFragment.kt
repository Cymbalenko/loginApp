package com.navsupport.loginapp.ui.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.s95ammar.loginapp.R
import com.navsupport.loginapp.ui.activity.SharedViewModel
import com.navsupport.loginapp.ui.login.LoginFragment
import com.navsupport.loginapp.ui.login.common.WelcomeUiEvent
import com.navsupport.loginapp.ui.paymentMethods.PaymentMethodsFragment
import com.navsupport.loginapp.util.Event

class WelcomeFragment : Fragment() {


    private val viewModel: WelcomeViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val welcomeTextView = view.findViewById<TextView>(R.id.welcome_text_view)
        val logoutButton = view.findViewById<Button>(R.id.logout_button)
        val paymentButton = view.findViewById<Button>(R.id.choose_payment_button)
        sharedViewModel.login.observe(viewLifecycleOwner) { login ->
            welcomeTextView.text = getString(R.string.format_welcome, login)
        }
        logoutButton.setOnClickListener {
            viewModel.onLogout()
        }

        viewModel.logoutEvent.observe(viewLifecycleOwner) { login ->
            navigateToLoginFragment()
        }

        viewModel.uiEvent.observe(viewLifecycleOwner) { event ->
            handleEvent(event)
        }
        paymentButton.setOnClickListener {
            viewModel.onPaymentMethods()
        }
        viewModel.paymentEvent.observe(viewLifecycleOwner) { p ->
            navigateToPaymentMethodsFragment()
        }
    }
    private fun handleEvent(event: Event<WelcomeUiEvent>) {
        event.getIfNotHandled()?.let { welcomeEvent ->
            when (welcomeEvent) {
                is WelcomeUiEvent.Loading -> {
                    val progressBar = view?.findViewById<ProgressBar>(R.id.loading_progress_bar_logout)
                    val logoutButton = view?.findViewById<Button>(R.id.logout_button)

                    progressBar?.isVisible = welcomeEvent.isLoading
                    logoutButton?.isGone = welcomeEvent.isLoading
                }
            }
        }
    }
    private fun navigateToLoginFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, LoginFragment())
            .commit()
    }
    private fun navigateToPaymentMethodsFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, PaymentMethodsFragment())
            .commit()
    }
}