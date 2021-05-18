package com.alexlianardo.moviecatalogue.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alexlianardo.moviecatalogue.fragment.MoviesFragment
import com.alexlianardo.moviecatalogue.fragment.TvShowsFragment

class ViewPagerAdapter(activity : AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MoviesFragment()
            1 -> fragment = TvShowsFragment()
        }
    return fragment as Fragment}
}