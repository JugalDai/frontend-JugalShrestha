package com.jugal.travelnepal

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.jugal.travelnepal.adapter.BookingAdapter
import com.jugal.travelnepal.api.ServiceBuilder
import com.jugal.travelnepal.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class DeleteBooking {

        @get:Rule
        val testrule = ActivityScenarioRule(MainActivity::class.java)

        @Test
        fun deleteBookingUITest() {
            runBlocking {
                var userRepos = UserRepository()
                ServiceBuilder.token = "Bearer " + userRepos.checkUser("Aakash", "1111").token

            }
            onView(withId(R.id.ic_home)).perform(click())
            Thread.sleep(1000)

            onView(withId(R.id.bookingRecyclerView)).perform(
                RecyclerViewActions.actionOnItemAtPosition<BookingAdapter.BookingViewHolder>
                    (1, clickOnViewChild(R.id.cancel_button)),
            )



            onView(withId(android.R.id.button1)).perform(click());

            Espresso.onView(withId(R.id.bottom_navigation))
                .check(matches(ViewMatchers.isDisplayed()))
        }


        private fun clickOnViewChild(viewId: Int) = object : ViewAction {
            override fun getConstraints() = null

            override fun getDescription() = "Click on a child view with specified id."

            override fun perform(uiController: UiController, view: View) =
                click().perform(uiController, view.findViewById<View>(viewId))
        }

}
