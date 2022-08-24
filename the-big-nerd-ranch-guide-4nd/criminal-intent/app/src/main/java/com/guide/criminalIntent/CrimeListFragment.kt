package com.guide.criminalIntent

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/24
 * @desc
 */

private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment() {
    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }
    }

    private val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProvider(this)[CrimeListViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${crimeListViewModel.crimes.size}")
    }
}