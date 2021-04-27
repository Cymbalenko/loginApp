package com.navsupport.loginapp.ui.paymentMethods

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.navsupport.loginapp.ui.paymentMethods.adapter.PaymentMethodsAdapter
import com.s95ammar.loginapp.R

class PaymentMethodsFragment : Fragment() {

    companion object {
        fun newInstance() = PaymentMethodsFragment()
    }
    private val viewModel:PaymentMethodsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.payment_methods_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerview=view.findViewById<RecyclerView>(R.id.payments_recyclerview)
        recyclerview.layoutManager= LinearLayoutManager(requireContext())
        val productAdapter=PaymentMethodsAdapter()
        productAdapter.list=viewModel.getFakeData(requireContext())
        recyclerview.adapter=productAdapter

    }

}