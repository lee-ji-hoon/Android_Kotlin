package com.shoppi.app.repository.category

import com.shoppi.app.model.Category
import com.shoppi.app.network.ApiClient

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/28
 * @desc
 */

class CategoryRemoteDataSource(
    private val apiClient: ApiClient
) : CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}