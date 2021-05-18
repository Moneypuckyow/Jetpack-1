package com.alexlianardo.moviecatalogue.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.alexlianardo.moviecatalogue.R
import com.alexlianardo.moviecatalogue.utiils.Data
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dataMovies = Data.getMovies()
    private val dataTvnShows = Data.getTvShows()


    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.recycler_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataMovies.size))
    }

    @Test
    fun loadDetailMovies(){
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.recycler_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.txtTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTitle)).check(matches(withText(dataMovies[0].title)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dataMovies[0].genre)))
        onView(withId(R.id.duration)).check(matches(isDisplayed()))
        onView(withId(R.id.duration)).check(matches(withText(dataMovies[0].duration)))
    }

    @Test
    fun loadTvnShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.recycler_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataTvnShows.size))
    }

    @Test
    fun loadDetailTvnShows(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.recycler_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.txtTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.txtTitle)).check(matches(withText(dataTvnShows[0].title)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dataTvnShows[0].genre)))
        onView(withId(R.id.duration)).check(matches(isDisplayed()))
        onView(withId(R.id.duration)).check(matches(withText(dataTvnShows[0].duration)))
    }
}