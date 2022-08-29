package com.shoppi.app.repository.categorydetail

import com.shoppi.app.model.CategoryDetail

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/29
 * @desc
 */

class CategoryDetailRepository(
    private val remoteDataSource: CategoryDetailRemoteDataSource
) {
    suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }
}