package com.shoppi.app.repository.home

import com.google.gson.Gson
import com.shoppi.app.AssetLoader
import com.shoppi.app.model.HomeData

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/28
 * @desc
 */

class HomeAssetDataSource(
    private val assetLoader: AssetLoader
) : HomeDataSource {
    private val gson = Gson()
    override fun getHomeData(): HomeData? {
        return assetLoader.getJsonString("home.json")?.let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}