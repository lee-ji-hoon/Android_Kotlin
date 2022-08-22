package com.guide.geoGuiz

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.guide.geoGuiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding // 컴파일 시점에 초기화 되는 것은 불가능하기 때문에 lateinit
    private val correctUserQuestions = mutableSetOf<Int>()
    private var currentIndex = 0
    private val TAG = "MainActivity"

    // TODO 모델 데이터를 저장하는 더 좋은 방법이 있지만 우선은 간단하게 List로 생성해서 사용하기
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        Log.d(TAG, "create")
        setContentView(mainBinding.root)
        val btnTrue = mainBinding.btnTrue
        val btnFalse = mainBinding.btnFalse
        val btnNext = mainBinding.btnNext
        val btnPrev = mainBinding.btnPrevious
        val tvQuestion = mainBinding.tvQuestion

        updateQuestion(tvQuestion)
        btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        btnNext.setOnClickListener {
            updateNextQuestion(tvQuestion)
        }

        // 챌린지 1. TextView에 리스너추가
        tvQuestion.setOnClickListener {
            updateNextQuestion(tvQuestion)
        }

        // 챌린지 2. PREVIOUS 버튼 추가
        btnPrev?.setOnClickListener {
            updatePrevQuestion(tvQuestion)
        }
    }

    /**
     * 이미 푼 문제인지 확인하는 함수
     */
    private fun isOverlapQuestion() {
        val currentQuestionId = questionBank[currentIndex].textResId
        when (correctUserQuestions.contains(currentQuestionId)) {
            // stack에 존재한다면 false -> 버튼 클릭 못하게 바꿈
            true -> changedButtonEnabled(false)
            false -> changedButtonEnabled(true)
        }
    }

    /**
     * 버튼 상태 갱신
     */
    private fun changedButtonEnabled(enabled: Boolean) {
        mainBinding.btnTrue.isEnabled = enabled
        mainBinding.btnFalse.isEnabled = enabled
    }

    /**
     * 이전 질문으로 돌아가기
     */
    private fun updatePrevQuestion(tvQuestion: TextView) {
        if (currentIndex > 0) {
            currentIndex -= 1
            updateQuestion(tvQuestion)
        }
    }

    /**
     * 다음 질문으로 가기
     */
    private fun updateNextQuestion(tvQuestion: TextView) {
        currentIndex = (currentIndex + 1) % questionBank.size
        updateQuestion(tvQuestion)
    }

    /**
     * 질문 업데이트
     */
    private fun updateQuestion(tvQuestion: TextView) {
        isOverlapQuestion()
        val questionTextResId = questionBank[currentIndex].textResId
        tvQuestion.setText(questionTextResId)
    }

    /**
     * 정답 확인
     */
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = when (userAnswer == correctAnswer) {
            // 챌린지 1. 정답 맞춘 문제를 건너띄기
            true -> {
                correctUserQuestions.add(questionBank[currentIndex].textResId)
                mainBinding.btnTrue.isEnabled = false
                mainBinding.btnFalse.isEnabled = false
                R.string.correct_toast
            }
            false -> R.string.inCorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }
}