package com.guide.geoGuiz

import androidx.lifecycle.ViewModel

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/22
 * @desc
 */
private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {
    var currentIndex = 0

    // TODO 모델 데이터를 저장하는 더 좋은 방법이 있지만 우선은 간단하게 List로 생성해서 사용하기
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true),
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionId: Int
        get() = questionBank[currentIndex].textResId
    val currentQuestionIsCheat: Boolean
        get() = questionBank[currentIndex].isCheat
    val questionBoxSize
        get() = questionBank.size
    val getCheatCount: Int
        get() = questionBank.filter { it.isCheat }.size
    fun moveToLast() { currentIndex = questionBoxSize - 1 }
    fun moveToNext() { currentIndex = (currentIndex + 1) % questionBank.size}
    fun moveToPrev() { currentIndex-- }
    fun useCheat() {questionBank[currentIndex].isCheat = true}
}