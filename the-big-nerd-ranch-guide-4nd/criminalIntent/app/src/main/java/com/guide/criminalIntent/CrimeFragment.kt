package com.guide.criminalIntent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.guide.criminalIntent.databinding.ActivityMainBinding
import com.guide.criminalIntent.databinding.FragmentCrimeBinding

/**
 * @author jihoon
 * @email dlwlgns1240@gmail.com
 * @created 2022/08/24
 * @desc
 */

// 모델 및 뷰 객체와 상호 작용하는 컨트롤러
class CrimeFragment : Fragment() {
    private lateinit var crime: Crime
    private lateinit var binding: FragmentCrimeBinding
    private lateinit var dataButton: Button
    private lateinit var solvedCheckBox: CheckBox
    private lateinit var titleField: EditText

    // 프래그먼트 인스턴스 생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCrimeBinding.inflate(layoutInflater)
        crime = Crime()
    }

    // 프래그먼트 뷰의 레이아웃 생성 및 구성
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        titleField = binding.crimeTitle
        dataButton = binding.btnCrimeDate.apply {
            text = crime.date.toString()
            isEnabled = false
        }
        solvedCheckBox = binding.cbCrimeSolved
        return inflater.inflate(R.layout.fragment_crime, container, false)
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {
            } // 사용할 일 없음

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(p0: Editable?) {} // 사용할 일 없음
        }
        titleField.addTextChangedListener(titleWatcher)

        solvedCheckBox.apply {
            setOnCheckedChangeListener {_, isChecked ->
                crime.isSolved = isChecked
            }
        }
    }
}