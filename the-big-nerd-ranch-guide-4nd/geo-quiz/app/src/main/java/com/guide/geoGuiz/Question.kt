package com.guide.geoGuiz

import androidx.annotation.StringRes

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/21
 * @desc
 */

// @StringRes 생성자에서 유효한 문자열 리소스 ID를 제공하는지를 컴파일 시점에서 Lint가 검사한다.
// Lint는 안드로이드 스튜디오에 내장된 코드 검사기이다.
// 이러한 방법을 사용해서 런타임 시에 앱이 중단되는 것을 방지할 수 있다.
data class Question(
    @StringRes val textResId: Int,
    val answer: Boolean
)
