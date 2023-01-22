package com.example.currencyapp.ui.screen.currency

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.databinding.ItemCurrencyBinding

/**
 * Created by ivankiv on 27,December,2022
 */
class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private val items: MutableList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding.root) {
            setOnClickListener {
                findNavController().navigate(
                    CurrencyFragmentDirections.actionCurrencyFragmentToCurrencyDetailFragment(
                        position.toString()
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return 5
    }


    inner class ViewHolder(internal val binding: ItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root)


}