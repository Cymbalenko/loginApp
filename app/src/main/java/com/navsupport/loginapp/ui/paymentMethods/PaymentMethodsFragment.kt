package com.navsupport.loginapp.ui.paymentMethods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.navsupport.loginapp.Constants
import com.navsupport.loginapp.ui.model.Payment
import com.navsupport.loginapp.ui.paymentMethods.adapter.PaymentMethodsAdapter
import com.s95ammar.loginapp.R

class PaymentMethodsFragment : Fragment() {

    companion object {
        fun newInstance() = PaymentMethodsFragment()
    }
    private val viewModel:PaymentMethodsViewModel by viewModels()
    private val productAdapter=PaymentMethodsAdapter { payment ->
        viewModel.onPaymentItemClick(payment)
        sendProductResultAndExit(payment)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.payment_methods_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerview=view.findViewById<RecyclerView>(R.id.payments_recyclerview)

        recyclerview.adapter=productAdapter
        recyclerview.layoutManager= LinearLayoutManager(requireContext())


        viewModel.paymentMethods.observe(viewLifecycleOwner) { paymentMethods ->
            productAdapter.submitList(paymentMethods)
            productAdapter.notifyDataSetChanged()
        }
    }

    private fun sendProductResultAndExit(payment: Payment) {
        setFragmentResult(
            Constants.REQUEST_KEY_RESULT_PAYMENT_BUNDLE,
            bundleOf(Constants.KEY_PAYMENT to payment)
        )
        parentFragmentManager.popBackStack()
    }

}