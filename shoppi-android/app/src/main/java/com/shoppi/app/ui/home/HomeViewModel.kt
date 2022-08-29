package com.shoppi.app.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.app.model.Banner
import com.shoppi.app.model.Category
import com.shoppi.app.model.Title
import com.shoppi.app.repository.home.HomeRepository
import com.shoppi.app.ui.common.Event
import kotlinx.coroutines.launch

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/28
 * @desc
 */

class HomeViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _title = MutableLiveData<Title>() // 수정은 가능하지만 접근이 불가능하다.
    val title: LiveData<Title> = _title // 접근은 가능하다.

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    private val _openBannerEvent = MutableLiveData<Event<String>>()
    val openBannerEvent: LiveData<Event<String>> = _openBannerEvent

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        viewModelScope.launch {
            val homeData = homeRepository.getHomeData()
            homeData?.let { homeData ->
                _title.value = homeData.title
                _topBanners.value = homeData.topBanners
            }
        }
    }
    fun openProductDetail(productId: String){
        _openBannerEvent.value = Event(productId)
    }
}