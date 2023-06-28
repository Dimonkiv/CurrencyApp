package com.example.currencyapp.ui.screen.currency

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.currencyapp.R
import com.example.currencyapp.databinding.ItemCurrencyBinding
import com.example.currencyapp.domain.ExchangeRate
import com.example.currencyapp.utils.DrawableHelper
import com.example.currencyapp.utils.ExchangeRateDiffCallback

/**
 * Created by ivankiv on 27,December,2022
 */
class CurrencyAdapter(private val context: Context) : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private val items = mutableListOf<ExchangeRate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        bindTitle(holder.binding, item)
        bindRate(holder.binding, item)

        with(holder.binding) {

            flagIv.setImageDrawable(DrawableHelper.getDrawableByName(context, item.icon))

            root.setOnClickListener {
                root.findNavController().navigate(
                    CurrencyFragmentDirections.actionCurrencyFragmentToCurrencyDetailFragment(
                        position.toString()
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


    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(newItems: List<ExchangeRate>) {
        val callback = ExchangeRateDiffCallback(items, newItems)
        val diffResult = DiffUtil.calculateDiff(callback)
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }



    inner class ViewHolder(internal val binding: ItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root)


}