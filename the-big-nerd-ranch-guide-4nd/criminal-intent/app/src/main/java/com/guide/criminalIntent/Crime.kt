package com.guide.criminalIntent

import java.util.*

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/24
 * @desc
 */

data class Crime(
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var data: Date = Date(),
    var isSolved: Boolean = false
) {}
