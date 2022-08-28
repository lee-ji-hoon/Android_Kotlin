package com.shoppi.app.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.app.model.Category
import com.shoppi.app.repository.CategoryRepository
import kotlinx.coroutines.launch

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/28
 * @desc
 */

class CategoryViewModel(
    private val categoryRepository: CategoryRepository
) : ViewModel() {
    private val  _items = MutableLiveData<List<Category>>()
    var items: LiveData<List<Category>> = _items

    init {
        loadCategory()
    }
    private fun loadCategory() {
        // retrofit 라이브러리를 사용중이기 때문에 쓰레드 전환 과정이 필요가 없다.
        viewModelScope.launch {
            val categories = categoryRepository.getCategories()
            _items.value = categories
        }
    }
}