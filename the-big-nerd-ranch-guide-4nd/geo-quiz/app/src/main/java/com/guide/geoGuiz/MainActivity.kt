package com.guide.geoGuiz

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.guide.geoGuiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding // 컴파일 시점에 초기화 되는 것은 불가능하기 때문에 lateinit
    private val correctQuestions = mutableSetOf<Int>()
    private val TAG = "MainActivity"

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProvider(this)[QuizViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "create")
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        updateQuestion()
        mainBinding.btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        mainBinding.btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        mainBinding.btnNext.setOnClickListener {
            updateNextQuestion()
        }

        // 챌린지 1. TextView에 리스너추가
        mainBinding.tvQuestion.setOnClickListener {
            updateNextQuestion()
        }

        // 챌린지 2. PREVIOUS 버튼 추가
        mainBinding.btnPrevious?.setOnClickListener {
            updatePrevQuestion()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "destroy")
    }

    /**
     * 이미 푼 문제인지 확인하는 함수
     */
    private fun isOverlapQuestion() {
        val currentQuestionId = quizViewModel.currentQuestionId
        when (correctQuestions.contains(currentQuestionId)) {
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
    private fun updatePrevQuestion() {
        if (quizViewModel.getCurrentIndex == 0) quizViewModel.moveToLast()
        else quizViewModel.moveToPrev()
        updateQuestion()
    }

    /**
     * 다음 질문으로 가기
     */
    private fun updateNextQuestion() {
        Log.d(TAG, "updateNextQuestion | 클릭 전 question : ${quizViewModel.currentQuestionId}, ${quizViewModel.getCurrentIndex}")
        quizViewModel.moveToNext()
        Log.d(TAG, "updateNextQuestion | 클릭 후 question : ${quizViewModel.currentQuestionId}, ${quizViewModel.getCurrentIndex}")
        updateQuestion()
    }

    /**
     * 질문 업데이트
     */
    private fun updateQuestion() {
        // 챌린지 1. 정답 맞춘 문제를 건너띄기
        isOverlapQuestion()
        val questionTextResId = quizViewModel.currentQuestionId
        Log.d(TAG, "updateQuestion | 현재 question : ${questionTextResId}")
        mainBinding.tvQuestion.setText(questionTextResId)
    }

    /**
     * 정답 확인
     */
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        Log.d(TAG, "checkAnswer | 현재 question : ${quizViewModel.currentQuestionId}")
        val messageResId = when (userAnswer == correctAnswer) {
            // 챌린지 2. 점수 보여주기. -> 마지막 문제인지 확인하고 마지막이면 정답 체크 후 점수를 백분율로 보여주기.
            true -> {
                correctQuestions.add(quizViewModel.currentQuestionId)
                changedButtonEnabled(false)
                R.string.correct_toast
            }
            false -> R.string.inCorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
        checkLastQuestion()
    }

    /**
     * 마지막 문제에서 몇 개 맞췄는지 확인
     */
    private fun checkLastQuestion() {
        if (quizViewModel.getCurrentIndex == quizViewModel.questionBoxSize - 1) {
            val ratioCorrectQuestion =
                ((correctQuestions.size.toDouble() / quizViewModel.questionBoxSize.toDouble()) * 100.0).toInt()
            Toast.makeText(
                this,
                getString(R.string.ratio_correct, ratioCorrectQuestion),
                Toast.LENGTH_SHORT
            ).show()
        } else updateNextQuestion()
    }
}