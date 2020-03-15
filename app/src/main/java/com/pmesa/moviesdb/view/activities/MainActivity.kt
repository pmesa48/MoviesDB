package com.pmesa.moviesdb.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.view.fragments.TopRatedMoviesFragment
import com.pmesa.moviesdb.viewmodel.TopRatedMoviesViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        renderFragment(
            TopRatedMoviesFragment.newInstance("Upcoming", TopRatedMoviesViewModel.UPCOMING),
            R.id.main_activity_fragment_container
        )
        renderFragment(
            TopRatedMoviesFragment.newInstance("Popular", TopRatedMoviesViewModel.POPULAR),
            R.id.main_activity_fragment_container_second
        )
        renderFragment(
            TopRatedMoviesFragment.newInstance("Top Rated", TopRatedMoviesViewModel.TOP_RATED),
            R.id.main_activity_fragment_container_third
        )
    }

    private fun renderFragment(fragment : Fragment, resourceId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                resourceId,
                fragment
            )
            .commitNowAllowingStateLoss()
    }

}
