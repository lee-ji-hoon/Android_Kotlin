package com.guide.criminalIntent.database

import androidx.room.Dao
import androidx.room.Query
import com.guide.criminalIntent.Crime
import java.util.*

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/25
 * @desc
 */

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
    fun getCrimes(): List<Crime>

    @Query("SELECT * FROM crime WHERE id = (:id)")
    fun getCrime(id: UUID): Crime?
}