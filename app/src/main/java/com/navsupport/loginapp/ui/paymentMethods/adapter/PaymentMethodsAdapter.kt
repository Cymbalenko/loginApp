package com.navsupport.loginapp.ui.paymentMethods.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.navsupport.loginapp.ui.model.Payment
import com.s95ammar.loginapp.R

class PaymentMethodsAdapter : RecyclerView.Adapter<PaymentMethodsAdapter.PaymentMethodsViewHolder>(){
    var list= emptyList<Payment>()
    class  PaymentMethodsViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        fun bind(payment: Payment){
            val image = itemView.findViewById<ImageView>(R.id.payments_imageView)
            val description = itemView.findViewById<MaterialTextView>(R.id.description_textview)

            image.setImageResource(payment.id)
            description.text= payment.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_payment,parent,false)
        return PaymentMethodsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PaymentMethodsViewHolder, position: Int) {
        list.getOrNull(position)?.let { payment ->
            holder.bind(payment)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}