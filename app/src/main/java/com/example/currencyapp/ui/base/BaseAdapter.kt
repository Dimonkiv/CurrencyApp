package com.example.currencyapp.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.currencyapp.ui.base.BaseAdapter.ViewHolder

/**
 * Created by ivankiv on 06,July,2023
 */
abstract class BaseAdapter<T : Any, VB : ViewBinding>(
    private val diffCallback: DiffUtil.ItemCallback<T>
) : RecyclerView.Adapter<ViewHolder<VB>>() {

    private val items = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<VB> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = createBinding(inflater, parent)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder<VB>, position: Int) {
        val item = items[position]
        bindItem(holder.binding, item, position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(newItems: List<T>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = items.size

            override fun getNewListSize(): Int = newItems.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = items[oldItemPosition]
                val newItem = newItems[newItemPosition]
                return diffCallback.areItemsTheSame(oldItem, newItem)
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = items[oldItemPosition]
                val newItem = newItems[newItemPosition]
                return diffCallback.areContentsTheSame(oldItem, newItem)
            }
        })

        items.clear()
        items.addAll(newItems)

        diffResult.dispatchUpdatesTo(this)
    }

    protected abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup): VB

    protected abstract fun bindItem(binding: VB, item: T, pos: Int)

    class ViewHolder<VB : ViewBinding>(val binding: VB): RecyclerView.ViewHolder(binding.root)
}