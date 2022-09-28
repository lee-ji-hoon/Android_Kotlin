package com.android.serialization

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/09/28
 * @desc
 */

class ReceiverActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)
        val shareData = intent.getSerializableExtra("Serialize") as ShareData? ?: return
        findViewById<TextView>(R.id.tv_name_data).text = shareData.getName()
        findViewById<TextView>(R.id.tv_number_data).text = shareData.getNumber().toString()
        findViewById<TextView>(R.id.tv_serializable_data).text = shareData.isSerializable().toString()
    }
}