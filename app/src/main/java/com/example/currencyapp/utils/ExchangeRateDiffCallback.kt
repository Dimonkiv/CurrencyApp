package com.example.currencyapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.currencyapp.domain.ExchangeRate

/**
 * Created by ivankiv on 06,June,2023
 */
class ExchangeRateDiffCallback(
    private val oldItems: List<ExchangeRate>,
    private val newItems: List<ExchangeRate>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int  = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]

        return oldItem.title == newItem.title
    }
}