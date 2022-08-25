package com.guide.criminalIntent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/24
 * @desc
 */

@Entity // 데이터베이스 테이블의 구조를 정의
data class Crime(
    @PrimaryKey // 기본키라는 의미
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: Date = Date(),
    var isSolved: Boolean = false,
    var requirePolice: Boolean = false
) {}
