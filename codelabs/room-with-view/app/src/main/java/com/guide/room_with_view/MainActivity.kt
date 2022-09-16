package com.guide.room_with_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.guide.room_with_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        val factory = UserViewModelFactory("이지훈", 24)
        // ViewModel 인스턴스 가져오기 (tihs = MainActivity의 수명주기에 의존)
//        viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]

        binding.activity = this
//        binding.vmUser = viewModel

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, BlankFragment())
            .commit()
    }
}