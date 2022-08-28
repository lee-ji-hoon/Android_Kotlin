package com.shoppi.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shoppi.app.Banner
import com.shoppi.app.Title

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/28
 * @desc
 */

class HomeViewModel : ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    fun loadHomeData() {
        // TODO Data Layer - Repository 에 요청
    }
}