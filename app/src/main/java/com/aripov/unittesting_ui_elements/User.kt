package com.aripov.unittesting_ui_elements

import java.util.Base64.Encoder
import javax.crypto.Cipher

class User (
    private val email: String,
    private var password: String
){
    init {
        require(Regex("(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
            .containsMatchIn(email)) {
            "Invalid email address provided."
        }
        require(Regex("^(?=.*\\d.*\\d)(?=.*[A-Z])(?=.*[a-z]).{8,}\$").containsMatchIn(password)) {
            "Password must have 2 digits, 1 upper, " +
                    "1 lower case letters, and be 8 chars long."
        }
    }
    fun showUserInfo(): String = "$email\n${password}"
}