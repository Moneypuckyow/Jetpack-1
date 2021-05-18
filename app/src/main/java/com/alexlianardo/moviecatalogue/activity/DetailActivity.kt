package com.alexlianardo.moviecatalogue.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.alexlianardo.moviecatalogue.data.DetailViewModel
import com.alexlianardo.moviecatalogue.data.Model
import com.alexlianardo.moviecatalogue.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_CATEGORY = "extra_category"
    }

    private lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val id = extras.getString(EXTRA_DATA)
            val category = extras.getString(EXTRA_CATEGORY)
            if (id != null && category != null) {
                viewModel.setSelectedItem(id, category)
                val item = viewModel.getItemDetail()
                showFilmDetail(item)
            }
        }
    }

    private fun showFilmDetail(data : Model) {

        with (activityDetailBinding){

            genre.text = data.genre
            duration.text = data.duration
            txtTitle.text = data.title
            txtDescription.text = data.description

            Glide.with(this@DetailActivity)
                    .load(data.poster)
                    .into(imageView2)
        }
    }
}