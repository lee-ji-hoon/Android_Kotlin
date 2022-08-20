package com.dimo.exam10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iuList = listOf(
            SampleModel(R.drawable.iu_1, "아이유1"),
            SampleModel(R.drawable.iu_2, "아이유2"),
            SampleModel(R.drawable.iu_3, "아이유3"),
            SampleModel(R.drawable.iu_4, "아이유4"),
            SampleModel(R.drawable.iu_5, "아이유5"),
            SampleModel(R.drawable.iu_6, "아이유6"),
        )

        val rvSample1 = findViewById<RecyclerView>(R.id.rv_sample1)
        val rvSample2 = findViewById<RecyclerView>(R.id.rv_sample2)
        val rvSample3 = findViewById<RecyclerView>(R.id.rv_sample3)
        val adapter1 = SampleDataAdapter(iuList, R.layout.item_box_1)
        val adapter2 = SampleDataAdapter(iuList, R.layout.item_box_2)
        val adapter3 = SampleDataAdapter(iuList, R.layout.item_box_3)
        rvSample1.adapter = adapter1
        rvSample2.adapter = adapter2
        rvSample3.adapter = adapter3

        rvSample1.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)  // 가로로 스크롤 형태
        rvSample2.layoutManager = GridLayoutManager(this, 2) // 일정한 grid 형태
        rvSample3.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL) // 불규칙한 grid 형태
    }
}