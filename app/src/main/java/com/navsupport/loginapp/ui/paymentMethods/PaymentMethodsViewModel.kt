package com.navsupport.loginapp.ui.paymentMethods

import android.content.Context
import androidx.lifecycle.ViewModel
import com.navsupport.loginapp.ui.model.Payment
import com.s95ammar.loginapp.R

class PaymentMethodsViewModel : ViewModel() {
//Временно, поидее должно из быза браться данные
    fun getFakeData(context: Context):MutableList<Payment>{
        return mutableListOf(
            Payment(R.drawable.ic_bank_transfer,context.getString(R.string.bank_transfer)),
            Payment(R.drawable.ic_cash_payment,context.getString(R.string.cash)),
            Payment(R.drawable.ic_credit_card,context.getString(R.string.credit_card)),
            Payment(R.drawable.ic_crypto,context.getString(R.string.crypto)),
            Payment(R.drawable.ic_google_pay,context.getString(R.string.google_pay))
        )
    }
}