package com.dimo.exam13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMove = findViewById<Button>(R.id.btn_move)
        btnMove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                // applicationContext는 앱의 Context가 담긴 Activity의 속성이다.
                val subIntent = Intent(applicationContext, SubActivity::class.java)
                subIntent.putExtra("MESSAGE", "MainActivity에서 왔습니다.")
                startActivity(subIntent)
            }
        })
        val intent = intent
        val tvMessage = findViewById<TextView>(R.id.tv_message)
        Log.d("tvMessage", "${tvMessage}")
        intent.getStringExtra("OK_MESSAGE")?.let { message ->
            tvMessage.text = message
        }
    }
}