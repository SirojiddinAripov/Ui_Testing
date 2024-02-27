package com.aripov.unittesting_ui_elements

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.viewpager.widget.ViewPager
import junit.framework.TestCase.assertEquals
import org.hamcrest.Matchers
import org.hamcrest.core.StringContains.containsString
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

class MainActivityTester {
    private lateinit var scenario: ActivityScenario<MainActivity>
    private lateinit var decorView: View
    @Before
    fun setup(){
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)

    }
    @Test
    fun testLogin_ProperInformation() {
        val email = "uniqueEMail134sgdgf3f@gmail.com"
        val password = "CorrectPassword12"
        //type in email address in email editText
        onView(withId(R.id.etEmail)).perform(typeText(email))
        //type in password in password editText
        onView(withId(R.id.etPassword)).perform(typeText(password))
        Espresso.closeSoftKeyboard()
        //Prepare to be sent to the next screen
        Intents.init()
        //click the submit button
        onView(withId(R.id.btnSubmit)).perform(click())
        //go to the next screen
        intended(hasComponent(AfterLogin::class.java.name))
        Intents.release()
    }
    @Test
    fun testLogin_IncorrectEmail() {
        val email = ""
        val password = "CorrectPassword12"

        //type in email address in email editText
        onView(withId(R.id.etEmail)).perform(typeText(email))
        //type in password in password editText
        onView(withId(R.id.etPassword)).perform(typeText(password))
        Espresso.closeSoftKeyboard()
        //click the submit button
        onView(withId(R.id.btnSubmit)).perform(click())
        //Check for the error Text View
        onView(withId(R.id.tvError)).check(matches(withText(containsString("Invalid email."))))
    }
    @Test
    fun testLogin_IncorrectPassword() {
        val email = "example@example.com"
        val password = "badpass"

        //type in email address in email editText
        onView(withId(R.id.etEmail)).perform(typeText(email))
        //type in password in password editText
        onView(withId(R.id.etPassword)).perform(typeText(password))
        Espresso.closeSoftKeyboard()
        //click the submit button
        onView(withId(R.id.btnSubmit)).perform(click())
        //Check for the error Text View
        onView(withId(R.id.tvError)).check(matches(withText(containsString("Invalid password."))))
    }
    @Test
    fun testLogin_TakenEmail() {
        val email = "taken@email.com"
        val password = "CorrectPassword12"

        //type in email address in email editText
        onView(withId(R.id.etEmail)).perform(typeText(email))
        //type in password in password editText
        onView(withId(R.id.etPassword)).perform(typeText(password))
        Espresso.closeSoftKeyboard()
        //click the submit button
        onView(withId(R.id.btnSubmit)).perform(click())
        //Check for the error Text View
        onView(withId(R.id.tvError)).check(matches(withText(containsString("Email is already taken."))))
    }
}