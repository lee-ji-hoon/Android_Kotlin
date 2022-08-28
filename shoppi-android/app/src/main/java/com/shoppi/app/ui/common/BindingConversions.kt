package com.shoppi.app.ui.common

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.databinding.BindingConversion

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/28
 * @desc
 */

@BindingConversion
fun convertToColorDrawable(color: String): Drawable{
    return ColorDrawable(Color.parseColor(color))
}