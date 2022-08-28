package com.shoppi.app.repository

import com.shoppi.app.model.HomeData

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/28
 * @desc
 */

class HomeRepository(
    private val assetDataSource: HomeAssetDataSource
) {
    fun getHomeData(): HomeData? {
        return assetDataSource.getHomeData()
    }
}