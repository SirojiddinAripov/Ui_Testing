package com.aripov.unittesting_ui_elements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aripov.unittesting_ui_elements.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.etEmail.text
    }
}