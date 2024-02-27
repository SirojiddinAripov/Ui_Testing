package com.aripov.unittesting_ui_elements

import com.google.common.truth.Truth.assertThat
import org.junit.Assert.*

import org.junit.Test
import org.junit.jupiter.api.assertThrows

class UserTest {

    @Test
    fun `normal creation of user returns true`() {
        val email = "example@example.com"
        val password = "Example11"
        val result = User(email, password).showUserInfo()
        assertThat(result).isEqualTo("$email\n${password}")
    }
    @Test
    fun `invalid email creation of user throws exception`() {
        assertThrows<IllegalArgumentException> {
            val email = "example"
            val password = "Example11"
            User(email, password).showUserInfo()
        }
    }
    @Test
    fun `invalid password creation of user throws exception`() {
        assertThrows<IllegalArgumentException> {
            val email = "example"
            val password = "eeeeeeee"
            User(email, password).showUserInfo()
        }
    }
    @Test
    fun `empty information of user throws exception`() {
        assertThrows<IllegalArgumentException> {
            val email = ""
            val password = ""
            User(email, password).showUserInfo()
        }
    }
}