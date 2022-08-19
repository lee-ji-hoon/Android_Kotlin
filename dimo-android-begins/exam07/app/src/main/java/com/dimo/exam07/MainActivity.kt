package com.dimo.exam07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val productArray = arrayOf(
        ProductModel("김치찌개", 7000),
        ProductModel("삼겹살", 13000),
        ProductModel("계란찜", 3000)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productOption = findViewById<Spinner>(R.id.sp_productOption)
        val priceText = findViewById<TextView>(R.id.tv_price)
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, productArray)
        productOption.adapter = adapter
        productOption.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                with(productArray[position]) {
                    priceText.text = getString(R.string.price_name, name, price)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}