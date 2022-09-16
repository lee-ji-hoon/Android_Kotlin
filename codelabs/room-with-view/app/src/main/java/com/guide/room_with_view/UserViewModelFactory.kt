package com.guide.room_with_view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/09/14
 * @desc
 */

// Factory 생성인자로 name, age Param을 받아서 ViewModel 생성인자로 넘겨 초기값 설정이 가능
class UserViewModelFactory(var name: String, var age: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            UserViewModel(name, age) as T    // ViewModel 인스턴스 생성, create() 제네릭타입에 맞춰 T로 retrun
        } else {
            throw IllegalArgumentException()    // UserViewModel 클래스가 아니라면 예외 발생
        }
}