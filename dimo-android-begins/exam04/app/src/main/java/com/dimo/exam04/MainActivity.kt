package com.dimo.exam04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView = findViewById<ImageView>(R.id.img_iu1)
        val button = findViewById<Button>(R.id.btn_img_scaleType)

        var isDefaultByImg = true
        imgView.setOnClickListener {
            isDefaultByImg = !isDefaultByImg
            when (isDefaultByImg) {
                true -> imgView.setImageResource(R.drawable.img_iu_1)
                false -> imgView.setImageResource(R.drawable.img_iu_2)
            }
        }
        var isDefaultByBtn = true
        button.setOnClickListener {
            isDefaultByBtn = !isDefaultByBtn
            when (isDefaultByBtn) {
                true -> imgView.scaleType = ImageView.ScaleType.CENTER_CROP
                false -> imgView.scaleType = ImageView.ScaleType.CENTER_INSIDE
            }
        }
    }
}