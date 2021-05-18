package com.alexlianardo.moviecatalogue.data

import com.alexlianardo.moviecatalogue.utiils.Data
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModelTest: DetailViewModel

    private val moviesData = Data.getMovies()[0]
    private val moviesDataId = moviesData.id
    private val tvShowsData = Data.getTvShows()[0]
    private val tvShowsDataId = tvShowsData.id

    @Before
    fun testSetUpMovies(){
        viewModelTest = DetailViewModel()
        viewModelTest.setSelectedItem(moviesDataId, "movies")
    }

    @Test
    fun testGetMovies() {
        viewModelTest.setSelectedItem(moviesData.id, "movies")
        val movie = viewModelTest.getItemDetail()
        Assert.assertNotNull(movie)
        assertEquals(moviesData.id, movie.id)
        assertEquals(moviesData.title, movie.title)
        assertEquals(moviesData.description, movie.description)
        assertEquals(moviesData.duration, movie.duration)
        assertEquals(moviesData.genre, movie.genre)
        assertEquals(moviesData.poster, movie.poster)
    }


    @Before
    fun testSetUpTvShows(){
        viewModelTest = DetailViewModel()
        viewModelTest.setSelectedItem(tvShowsDataId, "tv_shows")
    }

    @Test
    fun testGetTvShows() {
        viewModelTest.setSelectedItem(tvShowsData.id, "tv_shows")
        val tvShows = viewModelTest.getItemDetail()
        Assert.assertNotNull(tvShows)
        assertEquals(tvShowsData.id, tvShows.id)
        assertEquals(tvShowsData.title, tvShows.title)
        assertEquals(tvShowsData.description, tvShows.description)
        assertEquals(tvShowsData.duration, tvShows.duration)
        assertEquals(tvShowsData.genre, tvShows.genre)
        assertEquals(tvShowsData.poster, tvShows.poster)
    }

}