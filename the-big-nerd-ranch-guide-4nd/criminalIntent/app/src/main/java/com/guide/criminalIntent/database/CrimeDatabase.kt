package com.guide.criminalIntent.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.guide.criminalIntent.Crime

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/25
 * @desc
 */

/**
 * 특정 엔티티 클래스는 여러 DB에 사용될 수 있다.
 * 이런 이유로 엔티티 클래스를 DB와 연관시켜줘야 Room이 테이블 생성하는데 사용할 수 있다.
 */
@Database(entities = [Crime::class], version = 1)
abstract class CrimeDatabase : RoomDatabase() {

}