package com.shoppi.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shoppi.app.R

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() { // AppCompatActivity() -> 이전 버전 호환한다는 의미
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")

        // 아이콘들 원본의 리소스와 다를 경우 해결 방법
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        bottomNavigationView.itemIconTintList = null // 기본 컬러값 사용안하게끔 변경

        val navController = supportFragmentManager.findFragmentById(R.id.container_main)?.findNavController()
        navController?.let {
            bottomNavigationView.setupWithNavController(it)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}