package com.android.serialization

import java.io.Serializable

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/09/28
 * @desc
 */

class ShareData : Serializable {
    private var name: String? = null
    private var number = 0
    private var isSerializable = false
    fun setName(a_name: String?) {
        name = a_name
    }

    fun setNumber(a_number: Int) {
        number = a_number
    }

    fun setSerializable(a_isSerializable: Boolean) {
        isSerializable = a_isSerializable
    }

    fun getName(): String? {
        return name
    }

    fun getNumber(): Int {
        return number
    }

    fun isSerializable(): Boolean {
        return isSerializable
    }
}