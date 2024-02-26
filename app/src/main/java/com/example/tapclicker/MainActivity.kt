package com.example.tapclicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tapclicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val counters = mutableListOf<Counter>()
    private lateinit var adapter: CounterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        binding.buttonAddCounter.setOnClickListener {
            val newCounter = Counter("Counter ${counters.size + 1}")
            counters.add(newCounter)
            adapter.notifyItemInserted(counters.size - 1)

            val intent = Intent(this, CounterActivity::class.java)
            intent.putExtra("COUNTER_ID", newCounter.id) // Assuming Counter has an ID field
            startActivity(intent)
        }

    }

    private fun setupRecyclerView() {
        adapter = CounterAdapter(counters)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
