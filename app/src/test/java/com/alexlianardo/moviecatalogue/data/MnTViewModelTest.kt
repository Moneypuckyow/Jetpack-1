package com.alexlianardo.moviecatalogue.data

import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class MnTViewModelTest : TestCase() {

    private lateinit var mntModel : MnTViewModel

    @Before
    override fun setUp() {
        mntModel = MnTViewModel()
    }

    @Test
    fun testGetMovies() {
        val movies = mntModel.getMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    fun testGetTvShows() {
        val tvnShows = mntModel.getTvShows()
        assertNotNull(tvnShows)
        assertEquals(10, tvnShows.size)
    }
}