package com.shoppi.app.repository.categorydetail

import com.shoppi.app.model.CategoryDetail
import com.shoppi.app.network.ApiClient

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/29
 * @desc
 */

class CategoryDetailRemoteDataSource(
    private val api: ApiClient
): CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }
}