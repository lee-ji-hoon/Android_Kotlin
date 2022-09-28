package com.android.serialization

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sender)
        findViewById<Button>(R.id.cmd_send).setOnClickListener {
            val shareData = ShareData()
            shareData.setName("jiHoon")
            shareData.setNumber(100)
            shareData.setSerializable(true)
            val intent = Intent()
            intent.component = ComponentName(packageName, ReceiverActivity::class.java.name)
            intent.putExtra("Serialize", shareData)
            startActivity(intent)
        }
    }
}