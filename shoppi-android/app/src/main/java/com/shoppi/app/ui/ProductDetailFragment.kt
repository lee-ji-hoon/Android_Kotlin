package com.shoppi.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shoppi.app.R

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/18
 * @desc
 */

class ProductDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }
}