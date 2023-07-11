package com.example.food.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.food.R

class MainActivity : AppCompatActivity() {
    private val binding by lazy {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}