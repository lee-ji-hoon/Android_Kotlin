package com.dimo.exam13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val extra = findViewById<TextView>(R.id.tv_extra)

        val intent = intent
        extra.text = intent.getStringExtra("MESSAGE")

        val btnOk = findViewById<Button>(R.id.btn_ok)
        btnOk.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                val mainIntent = Intent(applicationContext, MainActivity::class.java)
                mainIntent.putExtra("OK_MESSAGE", "다시 MAIN으로 돌아왔습니다.")
                startActivity(mainIntent)
                finish()
            }
        })
    }
}