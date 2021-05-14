package com.navsupport.loginapp.ui.paymentMethods

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.navsupport.loginapp.ui.model.Payment
import com.s95ammar.loginapp.R

class PaymentMethodsViewModel : ViewModel() {
//Временно, поидее должно из базы браться данные
    private val _payment = MutableLiveData<List<Payment>>()

    val paymentMethods: LiveData<List<Payment>> = _payment

    init {
        getFakeData()
    }
    fun getFakeData() {
       _payment.value = mutableListOf(
            Payment(R.drawable.ic_bank_transfer,R.string.bank_transfer),
            Payment(R.drawable.ic_cash_payment,R.string.cash),
            Payment(R.drawable.ic_credit_card,R.string.credit_card),
            Payment(R.drawable.ic_crypto,R.string.crypto),
            Payment(R.drawable.ic_google_pay,R.string.google_pay)
        )
    }
    fun onPaymentItemClick(payment: Payment){

    }
}