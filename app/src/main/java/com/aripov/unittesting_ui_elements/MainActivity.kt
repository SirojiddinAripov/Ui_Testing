package com.aripov.unittesting_ui_elements

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.aripov.unittesting_ui_elements.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var usersList: ArrayList<User> = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener(this)

        usersList.add(
            User("taken@email.com",
                "takenEmail12")
        )
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnSubmit -> {
                val user = attemptToCreateUser()
                if(user != null) {
                    val intent = Intent(this, AfterLogin::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                }
            }
        }
    }

    private fun attemptToCreateUser() : User? {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if(!UserInfoValidator.isValidEmail(email)){
            Toast.makeText(applicationContext, "Invalid email.", Toast.LENGTH_SHORT).show()
            return null
        } else if(!UserInfoValidator.isValidPassword(password)) {
            Toast.makeText(applicationContext, "Invalid password.", Toast.LENGTH_SHORT).show()
            return null
        }
        return User(email, password)
    }
}