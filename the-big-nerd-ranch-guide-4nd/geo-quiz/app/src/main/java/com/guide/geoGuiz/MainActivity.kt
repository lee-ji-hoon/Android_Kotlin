package com.guide.geoGuiz

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.guide.geoGuiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding // 컴파일 시점에 초기화 되는 것은 불가능하기 때문에 lateinit
    private var currentIndex = 0
    // TODO 모델 데이터를 저장하는 더 좋은 방법이 있지만 우선은 간단하게 List로 생성해서 사용하기
    private val questionBank = listOf(
        Question(R.string.question_americas, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val btnTrue = mainBinding.btnTrue
        val btnFalse = mainBinding.btnFalse
        val btnNext = mainBinding.btnNext
        val tvQuestion = mainBinding.tvQuestion
        btnTrue.setOnClickListener {
            Log.d("btn", "true btn 작동")
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            Log.d("btn", "false btn 작동")
            checkAnswer(false)
        }

        btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion(tvQuestion)
        }
        updateQuestion(tvQuestion)
    }

    private fun updateQuestion(tvQuestion: TextView) {
        val questionTextResId = questionBank[currentIndex].textResId
        tvQuestion.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = when (userAnswer == correctAnswer) {
            true -> R.string.correct_toast
            false -> R.string.inCorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
}