package com.navsupport.loginapp.ui.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.navsupport.loginapp.Constants
import com.s95ammar.loginapp.R
import com.navsupport.loginapp.ui.activity.SharedViewModel
import com.navsupport.loginapp.ui.login.common.WelcomeUiEvent
import com.navsupport.loginapp.ui.model.Payment
import com.navsupport.loginapp.ui.paymentMethods.PaymentMethodsFragment
import com.navsupport.loginapp.util.observeEvent
import com.s95ammar.loginapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {


    private val viewModel: WelcomeViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentWelcomeBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(Constants.REQUEST_KEY_RESULT_PAYMENT_BUNDLE) { _, bundle ->
            val payment = bundle.getParcelable<Payment>(Constants.KEY_PAYMENT)
            view.findViewById<TextView>(R.id.payment_text_view).text = payment?.let { getString(it.TextId) }
        }
        sharedViewModel.login.observe(viewLifecycleOwner) { login ->
            binding.welcomeTextView.text = getString(R.string.format_welcome, login)
        }

        viewModel.uiEvent.observeEvent(viewLifecycleOwner) { event ->
            handleEvent(event)
        }

        binding.logoutButton.setOnClickListener {
            viewModel.onLogout()
        }

        binding.choosePaymentButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, PaymentMethodsFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }

    }

    private fun handleEvent(welcomeEvent: WelcomeUiEvent) {
        when (welcomeEvent) {
            is WelcomeUiEvent.Loading -> {
                binding.logoutButton.isInvisible = welcomeEvent.isLoading
                binding.loadingProgressBarLogout.isVisible = welcomeEvent.isLoading
            }
            is WelcomeUiEvent.Logout -> {
                sharedViewModel.setLogin(null)
                parentFragmentManager.popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}