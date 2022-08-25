package com.guide.criminalIntent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guide.criminalIntent.databinding.FragmentCrimeListBinding
import com.guide.criminalIntent.databinding.ListItemCrimeBinding

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/24
 * @desc
 */

private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment() {

    private lateinit var crimeRecyclerView: RecyclerView
    private var adapter: CrimeAdapter? = null
    private lateinit var crimeListBinding: FragmentCrimeListBinding
    private lateinit var listItemCrimeBinding: ListItemCrimeBinding

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
        crimeListBinding = FragmentCrimeListBinding.inflate(layoutInflater)
        listItemCrimeBinding = ListItemCrimeBinding.inflate(layoutInflater)
        Log.d(TAG, "Total crimes: ${crimeListViewModel.crimes.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime_list, container, false)
        crimeRecyclerView = view.findViewById(R.id.crime_recycler_view)
        crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        Log.d(TAG, "onCreateView 실행")
        updateUI()
        return view
    }

    private fun updateUI() {
        Log.d(TAG, "updateUI 실행")
        val crimes = crimeListViewModel.crimes
        adapter = CrimeAdapter(crimes)
        crimeRecyclerView.adapter = adapter
    }

    private inner class CrimeHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView = listItemCrimeBinding.tvCrimeTitle
        val dateTextView = listItemCrimeBinding.tvCrimeDate
    }

    private inner class CrimeAdapter(var crimes: List<Crime>) :
        RecyclerView.Adapter<CrimeHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            Log.d(TAG, "onCreateViewHolder 실행")
            val view = layoutInflater.inflate(R.layout.list_item_crime, parent, false)
            return CrimeHolder(view)
        }

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            Log.d(TAG, "onBindViewHolder 실행")
            val crime = crimes[position]
            holder.apply {
                titleTextView.text = crime.title
                dateTextView.text = crime.date.toString()
            }
        }

        override fun getItemCount(): Int {
            Log.d(TAG, "getItemCount 실행")
            return crimes.size
        }
    }
}