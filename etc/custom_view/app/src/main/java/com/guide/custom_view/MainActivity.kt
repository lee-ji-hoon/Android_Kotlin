package com.guide.custom_view

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationView = findViewById<LottieAnimationView>(R.id.ani_view)

        var isChecked = false
        animationView.setOnClickListener {
            // 애니메이션 커스텀
            // onFloat(시작,종료) -> 0% ~ 100% -> 1이 100이다. 즉 50프로를 하고 싶으면 0.5f를 넣어주면 된다.
            // setDuration(지속시간)
            val animator = ValueAnimator.ofFloat(0f, 1.0f).setDuration(1000)
            animator.addUpdateListener { animation ->
                animationView.progress = animation.animatedValue as Float
            }

            isChecked = when (isChecked) {
                true -> {
                    animator.reverse()
                    false
                }
                false -> {
                    animator.start()
                    true
                }
            }
        }
    }
}