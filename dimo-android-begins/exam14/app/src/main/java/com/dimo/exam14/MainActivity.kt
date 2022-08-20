package com.dimo.exam14

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webButton = findViewById<Button>(R.id.btn_web)
        val sendButton = findViewById<Button>(R.id.btn_send)
        webButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/"))
            startActivity(intent)
        }
        sendButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "제목")
            intent.putExtra(Intent.EXTRA_TEXT, "공유할 내용입니다.")
            startActivity(intent)
        }
    }
}