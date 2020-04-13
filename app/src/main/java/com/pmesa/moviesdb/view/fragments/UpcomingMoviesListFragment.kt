package com.pmesa.moviesdb.view.fragments

import android.os.Bundle
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.viewmodel.MoviesListViewModel
import com.pmesa.moviesdb.viewmodel.UpcomingMoviesListViewModel

@Suppress("UNCHECKED_CAST")
class UpcomingMoviesListFragment : MoviesListFragment() {
    override fun getViewModelClass(): Class<MoviesListViewModel> =
        UpcomingMoviesListViewModel::class.java as Class<MoviesListViewModel>

    override fun title(): String  = getString(R.string.movies_lits_title_upcoming)

    companion object {

        fun newInstance() : MoviesListFragment {
            val args = Bundle()
            val topRatedMoviesFragment = UpcomingMoviesListFragment()
            topRatedMoviesFragment.arguments = args
            return topRatedMoviesFragment
        }
    }
}