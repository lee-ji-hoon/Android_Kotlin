package com.guide.criminalIntent

import androidx.lifecycle.ViewModel

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/24
 * @desc
 */

class CrimeListViewModel : ViewModel() {
    private val crimes = mutableListOf<Crime>()
    init {
        for (i in 0 until 100) {
            val crime = Crime()
            crime.title = "Crime #${i}"
            crime.isSolved = i % 2 == 0
            crimes.add(crime)
        }
    }
}