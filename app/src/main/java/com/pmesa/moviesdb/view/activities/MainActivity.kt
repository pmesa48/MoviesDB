package com.pmesa.moviesdb.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.model.usecases.GetMainViewCategoriesOrderUseCase
import com.pmesa.moviesdb.model.usecases.GetMainViewCategoriesOrderUseCase.Companion.POPULAR
import com.pmesa.moviesdb.model.usecases.GetMainViewCategoriesOrderUseCase.Companion.TOP_RATED
import com.pmesa.moviesdb.model.usecases.GetMainViewCategoriesOrderUseCase.Companion.UPCOMING
import com.pmesa.moviesdb.view.fragments.MoviesListFragment
import com.pmesa.moviesdb.viewmodel.MoviesListsViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        renderFragment(
            MoviesListFragment.newInstance("Upcoming", UPCOMING),
            R.id.main_activity_fragment_container
        )
        renderFragment(
            MoviesListFragment.newInstance("Popular", POPULAR),
            R.id.main_activity_fragment_container_second
        )
        renderFragment(
            MoviesListFragment.newInstance("Top Rated", TOP_RATED),
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
