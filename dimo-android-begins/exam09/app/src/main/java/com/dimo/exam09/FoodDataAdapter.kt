package com.dimo.exam09

import android.content.res.Resources
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

class FoodDataAdapter(
    private val list: List<FoodModel>
) : RecyclerView.Adapter<FoodDataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodDataViewHolder, position: Int) {
        val containerView = holder.containerView
        containerView.findViewById<TextView>(R.id.tv_name).text = list[position].name
        containerView.findViewById<TextView>(R.id.tv_price).text = containerView.resources.getString(R.string.price_text, list[position].price)
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}