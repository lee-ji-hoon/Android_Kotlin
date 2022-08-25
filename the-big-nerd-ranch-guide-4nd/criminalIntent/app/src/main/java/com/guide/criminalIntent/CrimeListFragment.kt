package com.guide.criminalIntent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/24
 * @desc
 */

private const val TAG = "CrimeListFragment"

class CrimeListFragment : Fragment() {
    private lateinit var crimeRecyclerView: RecyclerView
    private var adapter: CrimeAdapter? = CrimeAdapter(emptyList())

    companion object {
        fun newInstance(): CrimeListFragment {
            return CrimeListFragment()
        }

        const val TYPE_NORMAL = 0
        const val TYPE_POLICE = 1
    }

    private val crimeListViewModel: CrimeListViewModel by lazy {
        ViewModelProvider(this)[CrimeListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime_list, container, false)
        crimeRecyclerView = view.findViewById(R.id.crime_recycler_view)
        crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        crimeRecyclerView.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crimeListViewModel.crimeListLiveData.observe(viewLifecycleOwner) { crimes ->
            crimes?.let {
                Log.i(TAG, "Got crimes ${crimes.size}")
                updateUI(crimes)
            }
        }
    }

    private fun updateUI(crimes: List<Crime>) {
        adapter = CrimeAdapter(crimes)
        crimeRecyclerView.adapter = adapter
    }

    private inner class CrimeHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private lateinit var crime: Crime
        private val titleTextView = itemView.findViewById<TextView>(R.id.tv_crime_title)
        private val dateTextView = itemView.findViewById<TextView>(R.id.tv_crime_date)
        private val solvedImageView = itemView.findViewById<ImageView>(R.id.iv_solved)

        fun bind(crime: Crime) {
            this.crime = crime
            titleTextView.text = this.crime.title
            dateTextView.text = setDateFormat(this.crime.date)
            solvedImageView.visibility = when(crime.isSolved) {
                true -> View.VISIBLE
                false -> View.INVISIBLE
            }
        }

        private fun setDateFormat(date: Date): String {
            return SimpleDateFormat("EEEE, MMM dd, yyyy",Locale.getDefault()).format(date)
        }

        override fun onClick(p0: View?) {
            Toast.makeText(context, "${crime.title} | ${crime.date}", Toast.LENGTH_SHORT).show()
        }
    }

    private inner class CrimeAdapter(var crimes: List<Crime>) : RecyclerView.Adapter<CrimeHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            return when (viewType) {
                TYPE_POLICE -> CrimeHolder(layoutInflater.inflate(R.layout.list_item_crime_police,parent,false))
                else -> CrimeHolder(layoutInflater.inflate(R.layout.list_item_crime, parent, false))
            }
        }

        override fun getItemCount(): Int {
            return crimes.size
        }

        override fun getItemViewType(position: Int): Int {
            return TYPE_NORMAL
        }

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            val btn = holder.itemView.findViewById<Button>(R.id.btn_police)
            btn?.setOnClickListener {
                Toast.makeText(context, "경찰에게 연락 버튼 클릭", Toast.LENGTH_SHORT).show()
            }
            holder.bind(crimes[position])
        }
    }
}