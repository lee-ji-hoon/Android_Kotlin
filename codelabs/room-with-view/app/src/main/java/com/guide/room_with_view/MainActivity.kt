package com.guide.room_with_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.guide.room_with_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // binding 객체가 this의 액티비티 lifecycle을 참조하면서 데이터 변경이 생기면 refresh 해주겠다는 의미
        binding.lifecycleOwner = this

        // ViewModel 초기값 설정위해 Factory 사용 - 프로퍼티(name,age) 값 설정
        val factory = UserViewModelFactory("이지훈", 24)
        // ViewModel 인스턴스 가져오기 (tihs = MainActivity의 수명주기에 의존)
        viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]

        binding.activity = this
        binding.vmUser = viewModel

        // Fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, BlankFragment())    // xml id - fragment에 BlankFragment 연결
            .commit()
    }
}