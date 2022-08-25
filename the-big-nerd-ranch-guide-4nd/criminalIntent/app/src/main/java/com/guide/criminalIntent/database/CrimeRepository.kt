package com.guide.criminalIntent.database

import android.content.Context
import java.lang.IllegalStateException

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/25
 * @desc
 */

class CrimeRepository private constructor(context: Context) {
    companion object {
        private var INSTANCE: CrimeRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) INSTANCE = CrimeRepository(context)
        }

        fun get(): CrimeRepository {
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}