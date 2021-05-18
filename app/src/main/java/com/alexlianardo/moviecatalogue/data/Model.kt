package com.alexlianardo.moviecatalogue.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Model (
    val id: String,
    val title: String,
    val description: String,
    val duration: String,
    val genre: String,
    val poster: Int,
    val category: String
): Parcelable