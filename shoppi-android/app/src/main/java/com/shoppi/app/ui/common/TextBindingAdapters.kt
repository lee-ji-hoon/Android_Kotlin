package com.shoppi.app.ui.common

import android.text.SpannableString
import android.text.style.StrikethroughSpan
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.shoppi.app.R
import java.text.DecimalFormat
import kotlin.math.roundToInt

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/28
 * @desc
 */

private val decimalFormat = DecimalFormat("#,###")

@BindingAdapter("priceAmount")
fun applyPriceFormat(view: TextView, price: Int) {
    val spannablePrice = SpannableString(
        view.context.getString(
            R.string.unit_discount_currency,
            decimalFormat.format(price)
        )
    )
    spannablePrice.setSpan(StrikethroughSpan(), 0, spannablePrice.length, 0)
    view.text = spannablePrice
}

@BindingAdapter("priceAmount", "discountRate")
fun applyPriceDiscountRate(view: TextView, price: Int, discountRate: Int) {
    val discountPrice = (((100 - discountRate) / 100.0) * price).roundToInt()
    view.text = view.context.getString(
        R.string.unit_discount_currency,
        decimalFormat.format(discountPrice)
    )
}