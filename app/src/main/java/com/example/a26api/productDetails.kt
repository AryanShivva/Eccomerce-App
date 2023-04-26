package com.example.a26api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class productDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        supportActionBar?.hide()

        val headingTV = findViewById<TextView>(R.id.productName)
        val headingIV = findViewById<ImageView>(R.id.newsImage)
        val pricep=findViewById<TextView>(R.id.productPrice)
        val newstv = findViewById<TextView>(R.id.newsContent)




    }
}