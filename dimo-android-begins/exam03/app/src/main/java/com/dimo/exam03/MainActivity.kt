package com.dimo.exam03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dimo.exam03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edit = binding.etTest
        val btn = binding.btnTest
        val textview = binding.tvTest

        // 단 하나만 존재할때 아래처럼 사용한다!
        btn.setOnClickListener {
            if (edit.text.isBlank()) textview.text = "이름이 없습니다."
            else textview.text = getString(R.string.welcome_messages, edit.text)
        }
        // 위와 똑같다.
        /*binding.btnTest.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if (edit.text.isBlank()) textview.text = "이름이 없습니다."
                else textview.text ="${edit.text}님 환영합니다."
            }
        })*/
    }
}