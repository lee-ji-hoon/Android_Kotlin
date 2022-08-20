package com.dimo.exam09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val foodList = listOf(
        FoodModel("김밥", 2500),
        FoodModel("떡볶이", 3500),
        FoodModel("라면", 4000),
        FoodModel("라볶이", 5500)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foodListView = findViewById<RecyclerView>(R.id.rv_foodList)
        val adapter = FoodDataAdapter(foodList)
        foodListView.adapter = adapter
        foodListView.layoutManager = LinearLayoutManager(this)
    }
}