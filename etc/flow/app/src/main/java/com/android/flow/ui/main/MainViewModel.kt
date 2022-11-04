package com.android.flow.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val flows = flow {
        for (i in 0..10) {
            emit(i)
            delay(1000)
        }
    }

    init {
        viewModelScope.launch {
            flows.onEach {
                println("Thread -> ${Thread.currentThread().name}")
                println("number emit -> ${it}")
            }.buffer().collect {
                delay(3000)
                println("Thread -> ${Thread.currentThread().name}")
                println("number consume ${it}")
            }
        }
    }
}