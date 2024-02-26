package com.example.tapclicker // ensure this matches the directory structure

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.content.Context

class CounterAdapter(private val counters: MutableList<Counter>) :
    RecyclerView.Adapter<CounterAdapter.CounterViewHolder>() {

    class CounterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val counterName: TextView = view.findViewById(R.id.counterName)
        val counterValue: TextView = view.findViewById(R.id.counterValue)
        // Initialize your increment and decrement buttons here
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CounterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.counter_item, parent, false)
        return CounterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CounterViewHolder, position: Int) {
        val counter = counters[position]
        holder.counterName.text = counter.name
        holder.counterValue.text = counter.value.toString()
        // Add button listeners here for increment, decrement, and reset
    }

    override fun getItemCount() = counters.size

    holder.itemView.setOnClickListener {
        val intent = Intent(context, CounterActivity::class.java)
        intent.putExtra("COUNTER_ID", counter.id)
        context.startActivity(intent)
    }

}
