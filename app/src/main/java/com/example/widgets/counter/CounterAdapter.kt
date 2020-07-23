package com.balocco.photogallery.gallery.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.widgets.R
import com.example.widgets.counter.CounterViewHolder
import java.util.*

class CounterAdapter constructor(
    context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var numbers: MutableList<Int> = ArrayList()
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    fun updateItems(newValues: List<Int>) {
        numbers.clear()
        numbers.addAll(newValues)
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = 0

    override fun getItemCount() = numbers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = layoutInflater.inflate(R.layout.listitem_counter, parent, false)
        return CounterViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = viewHolder as CounterViewHolder
        itemViewHolder.onBindViewHolder(numbers[position])
    }
}