package com.pmesa.moviesdb.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.model.usecases.GetMainViewCategoriesOrderUseCase.Companion.POPULAR
import com.pmesa.moviesdb.model.usecases.GetMainViewCategoriesOrderUseCase.Companion.TOP_RATED
import com.pmesa.moviesdb.model.usecases.GetMainViewCategoriesOrderUseCase.Companion.UPCOMING
import com.pmesa.moviesdb.view.fragments.MoviesListFragment
import com.pmesa.moviesdb.view.fragments.PopularMoviesListFragment
import com.pmesa.moviesdb.view.fragments.TopRatedMoviesListFragment
import com.pmesa.moviesdb.view.fragments.UpcomingMoviesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        renderFragment(
            UpcomingMoviesListFragment.newInstance(),
            R.id.main_activity_fragment_container
        )
        renderFragment(
            PopularMoviesListFragment.newInstance(),
            R.id.main_activity_fragment_container_second
        )
        renderFragment(
            TopRatedMoviesListFragment(),
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
