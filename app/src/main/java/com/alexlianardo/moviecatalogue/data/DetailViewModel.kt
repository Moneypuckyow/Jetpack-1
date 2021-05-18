package com.alexlianardo.moviecatalogue.data

import androidx.lifecycle.ViewModel
import com.alexlianardo.moviecatalogue.utiils.Data

class DetailViewModel : ViewModel() {
    companion object {
        const val MOVIES = "movies"
        const val TV_SHOWS = "tv_shows"
    }

    private lateinit var film: Model

    fun setSelectedItem(id : String, category: String) {
        when (category) {
            MOVIES -> {
                for (movies in Data.getMovies()){
                    if (movies.id == id) film = movies
                }
            }
            TV_SHOWS -> {
                for (tv_shows in Data.getTvShows()){
                    if (tv_shows.id == id) film = tv_shows
                }
            }
        }
    }

    fun getItemDetail() = film
}