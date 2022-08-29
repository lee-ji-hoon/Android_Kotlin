package com.shoppi.app.ui.common

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/29
 * @desc
 */

@BindingAdapter("isVisible")
fun updateVisibility(view: View, isVisible: Boolean){
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}