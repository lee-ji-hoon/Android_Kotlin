package com.shoppi.app.repository.category

import com.shoppi.app.model.Category

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