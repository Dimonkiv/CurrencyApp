package com.example.currencyapp.ui.screen.currency

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.currencyapp.databinding.ItemCurrencyBinding
import com.example.currencyapp.domain.ExchangeRate
import com.example.currencyapp.ui.base.BaseAdapter
import com.example.currencyapp.utils.DrawableHelper
import com.example.currencyapp.utils.ExchangeRateDiffCallback

/**
 * Created by ivankiv on 27,December,2022
 */
class CurrencyAdapter(
    private val context: Context
) : BaseAdapter<ExchangeRate, ItemCurrencyBinding>(
    ExchangeRateDiffCallback()
) {
    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup): ItemCurrencyBinding {
        return ItemCurrencyBinding.inflate(inflater, parent, false)
    }

    override fun bindItem(binding: ItemCurrencyBinding, item: ExchangeRate, pos: Int) {
        bindTitle(binding, item)
        bindRate(binding, item)

        with(binding) {

            flagIv.setImageDrawable(DrawableHelper.getDrawableByName(context, item.icon))

            root.setOnClickListener {
                root.findNavController().navigate(
                    CurrencyFragmentDirections.actionCurrencyFragmentToCurrencyDetailFragment(
                        pos.toString()
                    )
                )
            }
        }
    }

    private fun bindTitle(binding: ItemCurrencyBinding, item: ExchangeRate) {
        with(binding) {
            titleTv.text = item.title
            shortTitleTv.text = item.shortTitle
        }
    }

    private fun bindRate(binding: ItemCurrencyBinding, item: ExchangeRate) {
        with(binding) {
            if (item.rateCross == "0") {
                buyTv.text = item.rateBuy
                sellTv.text = item.rateSell
            } else {
                buyTv.visibility = View.GONE
                sellTv.text = item.rateCross
            }
        }
    }
}