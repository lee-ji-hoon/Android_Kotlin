package com.dimo.exam06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val nameArray = arrayOf("유아", "루다", "케이")
    private var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nameOption = findViewById<Spinner>(R.id.nameOption)
        val greetText = findViewById<TextView>(R.id.tv_greetText)

        adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, nameArray) // 제공되는 기본 레이아웃 사용
        nameOption.adapter = adapter

        nameOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                greetText.text = getString(R.string.greeting_text, nameArray[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}