package com.guide.criminalIntent

import android.app.Application
import android.util.Log
import com.guide.criminalIntent.database.CrimeRepository

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/25
 * @desc
 */

// TODO onCreate()임에도 불구하고 늦게 실행돼서 오류가 발생함
/*
class CriminalIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}*/
