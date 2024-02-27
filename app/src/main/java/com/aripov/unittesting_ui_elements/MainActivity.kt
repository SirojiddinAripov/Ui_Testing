package com.aripov.unittesting_ui_elements

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.aripov.unittesting_ui_elements.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var takenEmails: ArrayList<String> = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener(this)

        takenEmails.add("taken@email.com")
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.btnSubmit -> {
                val user = attemptToCreateUser()
                if (user != null){
                    if (user.email !in takenEmails) {
                        binding.tvError.visibility = View.GONE
                        val intent = Intent(this, AfterLogin::class.java)
                        intent.putExtra("user", user)
                        startActivity(intent)
                    } else {
                        displayErrorToUser("Email is already taken.")
                    }
                }
            }
        }
    }

    private fun attemptToCreateUser() : User? {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if(!UserInfoValidator.isValidEmail(email)){
            displayErrorToUser("Invalid email.")
            return null
        } else if(!UserInfoValidator.isValidPassword(password)) {
            displayErrorToUser("Invalid password.")
            return null
        }
        return User(email, password)
    }

    private fun displayErrorToUser(errorMessage: String){
        binding.tvError.visibility = View.VISIBLE
        binding.tvError.text = errorMessage
    }
}