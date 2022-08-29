package com.shoppi.app.ui.categorydetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.app.model.Promotion
import com.shoppi.app.model.TopSelling
import com.shoppi.app.repository.categorydetail.CategoryDetailRepository
import kotlinx.coroutines.launch

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/29
 * @desc
 */

class CategoryDetailViewModel(
    private val categoryDetailRepository: CategoryDetailRepository
) : ViewModel() {
    private val _topSelling = MutableLiveData<TopSelling>()
    var topSelling: LiveData<TopSelling> = _topSelling

    private val _promotions = MutableLiveData<Promotion>()
    var promotion: LiveData<Promotion> = _promotions

    init {
        loadCategoryDetail()
    }

    private fun loadCategoryDetail() {
        viewModelScope.launch {
            val categoryDetail = categoryDetailRepository.getCategoryDetail()
            _topSelling.value = categoryDetail.topSelling
            _promotions.value = categoryDetail.promotions
        }
    }
}