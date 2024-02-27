package com.aripov.unittesting_ui_elements

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UserInfoValidatorTest {

    @Test
    fun `empty email returns false`() {
        val email = ""
        val result = UserInfoValidator.isValidEmail(email)
        assertThat(result).isFalse()
    }
    @Test
    fun `improper email returns false`() {
        val email = "helloworld @email.com"
        val result = UserInfoValidator.isValidEmail(email)
        print(result)
        assertThat(result).isFalse()
    }
    @Test
    fun `email missing @ returns false`() {
        val email = "hello worldemail.com"
        val result = UserInfoValidator.isValidEmail(email)
        assertThat(result).isFalse()
    }
    @Test
    fun `email missing domain returns false`() {
        val email = "hello"
        val result = UserInfoValidator.isValidEmail(email)
        assertThat(result).isFalse()
    }
    @Test
    fun `email containing special chars returns false`() {
        val email = "!#$%^&*()@example.com"
        val result = UserInfoValidator.isValidEmail(email)
        assertThat(result).isFalse()
    }
    @Test
    fun `proper email returns true`() {
        val email = "example@example.com"
        val result = UserInfoValidator.isValidEmail(email)
        print( result.toString())
        assertThat(result).isTrue()
    }
    @Test
    fun `password less than 8 chars returns false`() {
        val password = "hello12"
        val result = UserInfoValidator.isValidPassword(password)
        assertThat(result).isFalse()
    }
    @Test
    fun `password missing 2 digits returns false`() {
        val password = "Helloworld"
        val result = UserInfoValidator.isValidPassword(password)
        assertThat(result).isFalse()
    }
    @Test
    fun `password missing upper case returns false`() {
        val password = "helloworld12"
        val result = UserInfoValidator.isValidPassword(password)
        assertThat(result).isFalse()
    }
    @Test
    fun `password missing lowe case returns false`() {
        val password = "HELLOWORLD12"
        val result = UserInfoValidator.isValidPassword(password)
        assertThat(result).isFalse()
    }
    @Test
    fun `proper password returns true`() {
        val password = "Helloworld12"
        val result = UserInfoValidator.isValidPassword(password)
        assertThat(result).isTrue()
    }
}