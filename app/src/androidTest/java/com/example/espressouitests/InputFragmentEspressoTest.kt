package com.example.espressouitests


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InputFragmentEspressoTest {

    @get:Rule
    val activityRule =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun userFillsFormAndSeesResult() {
        onView(withId(R.id.nameInput))
            .check(matches(isDisplayed()))

        onView(withId(R.id.nameInput))
            .perform(
                replaceText("Потап"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.ageInput))
            .perform(
                replaceText("105"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.cityInput))
            .perform(
                replaceText("Архангельск"),
                closeSoftKeyboard()
            )

        onView(withId(R.id.submitButton))
            .perform(click())

        onView(withId(R.id.resultText))
            .check(matches(isDisplayed()))
            .check(
                matches(
                    withText("Потап, 105 лет, город Архангельск")
                )
            )
    }
}