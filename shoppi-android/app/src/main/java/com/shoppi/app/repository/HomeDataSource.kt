package com.shoppi.app.repository

import com.shoppi.app.model.HomeData

// 여러 유형의 데이터 소스가 들어올수 있으므로 interface
interface HomeDataSource {

    fun getHomeData(): HomeData?
}