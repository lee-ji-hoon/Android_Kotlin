package com.guide.criminalIntent

import androidx.lifecycle.ViewModel
import com.guide.criminalIntent.database.CrimeRepository

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/24
 * @desc
 */

class CrimeListViewModel : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
}