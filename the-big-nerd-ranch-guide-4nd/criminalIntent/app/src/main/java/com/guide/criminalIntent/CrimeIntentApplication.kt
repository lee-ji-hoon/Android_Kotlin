package com.guide.criminalIntent

import android.app.Application
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.guide.criminalIntent.database.CrimeRepository

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/26
 * @desc
 */

class CrimeIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}