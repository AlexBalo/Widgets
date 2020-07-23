package com.example.widgets.counter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.widgets.R

class CounterViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private val numberText: TextView = itemView.findViewById(R.id.numberItem)

    fun onBindViewHolder(number: Int) {
        this.numberText.text = number.toString()
    }
}