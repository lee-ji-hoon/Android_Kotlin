package com.dimo.exam13

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var getResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMessage = findViewById<TextView>(R.id.tv_message)
        getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
                if (activityResult.resultCode == RESULT_OK) {
                    activityResult.data?.let {
                        tvMessage.text = it.getStringExtra("OK_MESSAGE")
                    }
                }
            }

        val btnMove = findViewById<Button>(R.id.btn_move)
        btnMove.setOnClickListener { // applicationContext는 앱의 Context가 담긴 Activity의 속성이다.
            val subIntent = Intent(applicationContext, SubActivity::class.java)
            subIntent.putExtra("MESSAGE", "MainActivity에서 왔습니다.")
            getResult.launch(subIntent)
        }
    }
}