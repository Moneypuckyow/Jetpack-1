package com.alexlianardo.moviecatalogue.data

import androidx.lifecycle.ViewModel
import com.alexlianardo.moviecatalogue.utiils.Data

class MnTViewModel: ViewModel() {
    fun getMovies() : List<Model> = Data.getMovies()
    fun getTvShows() : List<Model> = Data.getTvShows()
}