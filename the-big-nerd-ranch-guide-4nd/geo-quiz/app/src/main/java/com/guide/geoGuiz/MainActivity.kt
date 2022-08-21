package com.guide.geoGuiz

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.guide.geoGuiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding // 컴파일 시점에 초기화 되는 것은 불가능하기 때문에 lateinit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val btnTrue = mainBinding.btnTrue
        btnTrue.setOnClickListener {
            Log.d("btn", "true btn 작동")
            val toast = Toast.makeText(
                this, // 매개변수 Context는 일반적으로 Activity의 인스턴스이다. 즉 Activity는 Context의 서브 클래스라는 것을 알 수 있다.
                R.string.correct_toast,
                Toast.LENGTH_SHORT // 문자열을 얼마나 오래 보여줄지 정하는 것
            )
            toast.setGravity(Gravity.TOP, 200, 200)
            toast.show() // 문자열 호출해서 화면에 보이게 해줌
        }
        val btnFalse = mainBinding.btnFalse
        btnFalse.setOnClickListener {
            Log.d("btn", "false btn 작동")
            val toast = Toast.makeText(
                this,
                R.string.inCorrect_toast,
                Toast.LENGTH_SHORT
            )
            // api 28 까지만 위치 조정 가능
            toast.setGravity(Gravity.TOP,200, 200)
            toast.show()
        }
    }
}