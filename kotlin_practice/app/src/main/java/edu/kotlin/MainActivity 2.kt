package edu.kotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import edu.kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 기존 setContentView를 제거

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시
        setContentView(binding.root)

        // 이제부터 binding 바인딩 변수를 활용하여 마음껏 xml 파일 내의 뷰 id에 접근 가능
        // 뷰 id도 파스칼케이스 + 카멜케이스의 네이밍 규칙 적용으로 인해
        // text_view -> textView로 자동 변환
        binding.textView.setText("안녕하세요 이지훈입니다.")

        binding.button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                // TODO
            }
        })

        // 1. Kotlin interface가 아닌 자바 인터페이스여아만 한다.
        // 2. 그 인터페이스는 딱 하나의 메서드만 가져야 한다.
        binding.button.setOnClickListener{
          // TODO
        }
    }

    // 액티비티가 파괴될 때..
    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }
}