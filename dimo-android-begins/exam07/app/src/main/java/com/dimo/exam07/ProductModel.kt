package com.dimo.exam07

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/19
 * @desc
 */

class ProductModel(
    val name: String,
    val price: Int
) {
    override fun toString(): String {
        return name
    }
}