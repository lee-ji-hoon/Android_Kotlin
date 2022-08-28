package com.shoppi.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/18
 * @desc
 */

// 31부터 Splash를 따로 두면 안되지만 그 미만 버전에서는 필요하기 때문에 경고는 무시하고 진행하면 된다.
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MainActivity 호출하는 방법
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}