package com.dimo.exam08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private val numbers = mutableListOf(0, 1, 2, 3, 4, 5, 11)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.sp_numberOption)
        val notify = findViewById<TextView>(R.id.tv_notify)
        val addBtn = findViewById<Button>(R.id.btn_add)
        val removeBtn = findViewById<Button>(R.id.btn_remove)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, numbers)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                index: Int,
                id: Long
            ) {
                notify.text = getString(R.string.number_text, numbers[index])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        addBtn.setOnClickListener {
            var randomNumber: Int
            while (true) {
                randomNumber = (1..20).random()  // 1 <= n <= 20
                if (numbers.contains(randomNumber).not()) break
            }
            numbers.add(randomNumber)
            adapter.notifyDataSetChanged()
        }

        removeBtn.setOnClickListener {
            if (numbers.size > 1) { // 2개 이상 일때만 실행
                Log.d("remove", "${numbers.size}")
                Log.d("remove", "${numbers}")
                Log.d("remove", "삭제 시작")
                numbers.removeFirst()
                adapter.notifyDataSetChanged()
            }
        }
    }
}
