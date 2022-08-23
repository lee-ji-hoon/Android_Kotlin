package com.guide.geoGuiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.guide.geoGuiz.databinding.ActivityChaetBinding

const val EXTRA_ANSWER_SHOWN = "com.guide.geoquiz.answer_shown"
private const val EXTRA_ANSWER_IS_TRUE = "com.guide.geoquiz.answer_is_true"

class CheatActivity : AppCompatActivity() {
    private lateinit var answerTextView: TextView
    private lateinit var showAnswerButton: Button
    private lateinit var cheatBinding: ActivityChaetBinding
    private var answerIsTrue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cheatBinding = ActivityChaetBinding.inflate(layoutInflater)
        setContentView(cheatBinding.root)

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
        answerTextView = cheatBinding.tvAnswer
        showAnswerButton = cheatBinding.btnShowAnswer
        showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            answerTextView.setText(answerText)
            setAnswerShowResult()
        }

        // 안드로이드 버전 띄우기
        val tvVersion = cheatBinding.tvVersion
        val curVersion = Build.VERSION.SDK_INT
        tvVersion.append(getString(R.string.current_version, curVersion.toString()))
    }

    private fun setAnswerShowResult() {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, true)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}