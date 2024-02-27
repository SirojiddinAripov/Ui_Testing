package com.aripov.unittesting_ui_elements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aripov.unittesting_ui_elements.databinding.ActivityAfterLoginBinding

class AfterLogin : AppCompatActivity() {
    private lateinit var binding: ActivityAfterLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAfterLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(intent != null) {
            val user: User = intent.getSerializableExtra("user") as User
            binding.tvMain.text = user.showUserInfo()
        }
    }
}