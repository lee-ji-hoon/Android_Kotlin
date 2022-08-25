package com.guide.criminalIntent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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
    private lateinit var crimeListBinding: FragmentCrimeListBinding
    private lateinit var listItemCrimeBinding: ListItemCrimeBinding

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crimeListBinding = FragmentCrimeListBinding.inflate(layoutInflater)
        listItemCrimeBinding = ListItemCrimeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime_list, container, false)
        crimeRecyclerView = view.findViewById(R.id.crime_recycler_view)
        crimeRecyclerView.layoutManager = LinearLayoutManager(context)
        updateUI()
        return view
    }

    private fun updateUI() {
        val crimes = crimeListViewModel.crimes
        val adapter = CrimeAdapter(crimes)
        crimeRecyclerView.adapter = adapter
    }

    private inner class CrimeHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private lateinit var crime: Crime
        private val titleTextView = itemView.findViewById<TextView>(R.id.tv_crime_title) ?: null
        private val dateTextView = itemView.findViewById<TextView>(R.id.tv_crime_date) ?: null

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(crime: Crime) {
            this.crime = crime
            titleTextView?.text = this.crime.title
            dateTextView?.text = this.crime.date.toString()
        }

        override fun onClick(p0: View?) {
            Toast.makeText(context, "${crime.title} | ${crime.date}", Toast.LENGTH_SHORT).show()
        }
    }

    private inner class CrimeHolderWithPolice(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private lateinit var crime: Crime
        private val titleTextView = itemView.findViewById<TextView>(R.id.tv_crime_title) ?: null
        private val dateTextView = itemView.findViewById<TextView>(R.id.tv_crime_date) ?: null
        private val policeButton = itemView.findViewById<TextView>(R.id.btn_police) ?: null

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(crime: Crime) {
            this.crime = crime
            titleTextView?.text = this.crime.title
            dateTextView?.text = this.crime.date.toString()
        }

        override fun onClick(p0: View?) {
            Toast.makeText(context, "${crime.title} | ${crime.date} | 경찰에게 연락", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private inner class CrimeAdapter(var crimes: List<Crime>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return when (viewType) {
                TYPE_POLICE -> CrimeHolderWithPolice(layoutInflater.inflate(R.layout.list_item_crime_police,parent,false))
                else -> CrimeHolder(layoutInflater.inflate(R.layout.list_item_crime, parent, false))
            }
        }

        override fun getItemCount(): Int {
            return crimes.size
        }

        override fun getItemViewType(position: Int): Int {
            return if (crimes[position].requirePolice) TYPE_POLICE
            else TYPE_NORMAL
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (getItemViewType(position)) {
                TYPE_POLICE -> (holder as CrimeHolderWithPolice).bind(crimes[position])
                TYPE_NORMAL -> (holder as CrimeHolder).bind(crimes[position])
            }
        }
    }
}