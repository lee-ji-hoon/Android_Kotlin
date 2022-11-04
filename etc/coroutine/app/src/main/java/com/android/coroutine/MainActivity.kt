package com.android.coroutine

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            loadTask()
        }
        log("[onDraw]1 ->")
        log("[onDraw]2 ->")
        log("[onDraw]3 ->")
        log("[onDraw]4 ->")
        log("[onDraw]5 ->")
    }

    fun log(message: String) =
        Log.d("TAG","$message [${Thread.currentThread().name}]")

    suspend fun loadTask() {
        val resultTask1 = suspendTask1()
        updateItem("$resultTask1")
    }

    suspend fun suspendTask1(): String {
        log("[SuspendTask1] 시작 -> ")
        delay(3000) // 네트워크 연결 등으로 인해 잠시 멈추는 상태
        log("[SuspendTask1] 종료 -> ")
        return "task1 완료"
    }

    fun updateItem(s: String) {
        log("결과 : $s -> ")
    }
}