package com.guide.criminalIntent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guide.criminalIntent.database.CrimeRepository
import com.guide.criminalIntent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null){
            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager.beginTransaction() // FragmentTransaction의 인스턴스 생성 반환, fluent interface 를 사용
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}