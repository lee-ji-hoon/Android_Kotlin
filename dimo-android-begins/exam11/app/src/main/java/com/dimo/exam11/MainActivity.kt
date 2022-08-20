package com.dimo.exam11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val numbers = (0..100).toList().shuffled()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvInteger = findViewById<RecyclerView>(R.id.rv_integer)
        val adapter = DataAdapter(numbers)
        adapter.onItemSelectionChangedListener = {
            println("선택된 ID : ${it}")
        }
        rvInteger.adapter = adapter
        rvInteger.layoutManager = LinearLayoutManager(this)
    }
}