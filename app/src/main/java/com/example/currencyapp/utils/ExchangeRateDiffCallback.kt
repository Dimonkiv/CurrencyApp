package com.example.currencyapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.currencyapp.domain.ExchangeRate

/**
 * Created by ivankiv on 06,June,2023
 */
class ExchangeRateDiffCallback : DiffUtil.ItemCallback<ExchangeRate>() {

    override fun areItemsTheSame(oldItem: ExchangeRate, newItem: ExchangeRate): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ExchangeRate, newItem: ExchangeRate): Boolean {
        return oldItem.title == newItem.title
    }
}