package com.navsupport.loginapp.ui.paymentMethods.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.navsupport.loginapp.ui.model.Payment
import com.s95ammar.loginapp.R
import com.s95ammar.loginapp.databinding.ItemPaymentBinding


class PaymentMethodsAdapter(private val clickListener: (Payment) -> Unit) : ListAdapter<Payment, PaymentMethodsAdapter.PaymentMethodsViewHolder>(PaymentDiffUtil()){


    class  PaymentMethodsViewHolder(private val binding: ItemPaymentBinding,private val clickListener: (Payment) -> Unit): RecyclerView.ViewHolder(binding.root){

        fun bind(payment: Payment){
            itemView.setOnClickListener {clickListener(payment)}

            binding.paymentsImageView.setImageResource(payment.imageResId)
            binding.descriptionTextview.text = itemView.context.getString(payment.TextId)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_payment,parent,false)
        return PaymentMethodsViewHolder(ItemPaymentBinding.bind(view),clickListener)
    }

    override fun onBindViewHolder(holder: PaymentMethodsViewHolder, position: Int) {
        getItem(position).let { payment ->
            holder.bind(payment)
        }
    }
    class PaymentDiffUtil: DiffUtil.ItemCallback<Payment>(){
        override fun areItemsTheSame(oldItem: Payment, newItem: Payment): Boolean {
            return  oldItem.imageResId==newItem.imageResId
        }

        override fun areContentsTheSame(oldItem: Payment, newItem: Payment): Boolean {
            return  oldItem==newItem
        }

    }

}