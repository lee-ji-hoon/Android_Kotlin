package com.dimo.exam05

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("checkbox", "메인 시작")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.tv_test)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup_colorOption)
        val boldOption = findViewById<CheckBox>(R.id.checkbox_bold)
        val italicOption = findViewById<CheckBox>(R.id.checkbox_italic)

        boldOption.setOnCheckedChangeListener(this)
        italicOption.setOnCheckedChangeListener(this)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioBtn_red -> text.setTextColor(Color.RED)
                R.id.radioBtn_blue -> text.setTextColor(Color.BLUE)
                R.id.radioBtn_yellow -> text.setTextColor(Color.YELLOW)
            }
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        Log.d("checkbox", "체크박스 시작")
        var option = 0
        val text = findViewById<TextView>(R.id.tv_test)
        val boldOption = findViewById<CheckBox>(R.id.checkbox_bold)
        val italicOption = findViewById<CheckBox>(R.id.checkbox_italic)

        if (boldOption.isChecked) option += Typeface.BOLD
        if (italicOption.isChecked) option += Typeface.ITALIC

        text.setTypeface(null, option)
    }
}