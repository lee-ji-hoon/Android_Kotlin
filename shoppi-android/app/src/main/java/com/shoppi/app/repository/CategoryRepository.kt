package com.shoppi.app.repository

import com.shoppi.app.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/28
 * @desc
 */

class CategoryRepository(
    private val removeDataSource: CategoryDataSource
) {
    // suspend 키워드를 추가함으로써 코루틴 강제
    suspend fun getCategories(): List<Category> {
        return removeDataSource.getCategories()
    }
}