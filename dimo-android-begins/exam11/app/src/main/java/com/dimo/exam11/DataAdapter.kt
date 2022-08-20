package com.dimo.exam11

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/20
 * @desc
 */

class DataAdapter(
    private val list: List<Int>
) : RecyclerView.Adapter<DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_integer, parent, false)
        view.setOnClickListener { v ->
            val id = v?.tag
            if (selectionList.contains(id)) selectionList.remove(id)
            else selectionList.add(id as Long)
            notifyDataSetChanged()
            onItemSelectionChangedListener?.let { it (selectionList) }
        }
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val tvInteger = holder.itemView.findViewById<TextView>(R.id.tv_integer)
        tvInteger.text = list[position].toString()
        holder.itemView.tag = getItemId(position)
        holder.itemView.isActivated = selectionList.contains(getItemId(position))
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private val selectionList = mutableListOf<Long>()
    var onItemSelectionChangedListener : ((MutableList<Long>) -> Unit)? = null

    override fun getItemCount(): Int {
        return list.count()
    }
}