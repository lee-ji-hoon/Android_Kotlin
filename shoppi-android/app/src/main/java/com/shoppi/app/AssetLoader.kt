package com.shoppi.app

import android.content.Context
import android.util.Log

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/27
 * @desc
 */

class AssetLoader {
    fun getJsonString(context: Context, fileName: String): String? {
        return kotlin.runCatching {
            loadAsset(context, fileName)
        }.getOrNull()
    }

    private fun loadAsset(context: Context, fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)
        }
    }
}