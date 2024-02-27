package com.aripov.unittesting_ui_elements


class User (
    private val email: String,
    private var password: String
){
    init {
        require(UserInfoValidator.isValidEmail(email)) {
            "Invalid email address provided."
        }
        require(UserInfoValidator.isValidPassword(password)) {
            "Password must have 2 digits, 1 upper, " +
                    "1 lower case letters, and be 8 chars long."
        }
    }
    fun showUserInfo(): String = "$email\n${password}"
}