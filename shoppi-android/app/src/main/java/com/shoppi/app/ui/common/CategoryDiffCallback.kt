package com.shoppi.app.ui.common

import androidx.recyclerview.widget.DiffUtil
import com.shoppi.app.model.Category

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/29
 * @desc
 */

class CategoryDiffCallback: DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.categoryId == newItem.categoryId
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}