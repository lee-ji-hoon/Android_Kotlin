package com.dimo.exam10

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/20
 * @desc
 */

class SampleDataAdapter(
    private val list: List<SampleModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<SampleDataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return SampleDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: SampleDataViewHolder, position: Int) {
        holder.itemView.findViewById<ImageView>(R.id.img_sample).setImageResource(list[position].imageId)
        holder.itemView.findViewById<TextView>(R.id.tv_description).text = list[position].description
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}