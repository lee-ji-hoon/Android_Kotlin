package com.dimo.exam13

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val extra = findViewById<TextView>(R.id.tv_extra)

        extra.text = intent.getStringExtra("MESSAGE")

        val btnOk = findViewById<Button>(R.id.btn_ok)
        btnOk.setOnClickListener {
            val intent = Intent()
            intent.putExtra("OK_MESSAGE", "다시 MAIN으로 돌아왔습니다.")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}