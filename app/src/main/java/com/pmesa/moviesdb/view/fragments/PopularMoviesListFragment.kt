package com.pmesa.moviesdb.view.fragments

import android.os.Bundle
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.viewmodel.MoviesListViewModel
import com.pmesa.moviesdb.viewmodel.PopularMoviesViewModel

@Suppress("UNCHECKED_CAST")
class PopularMoviesListFragment : MoviesListFragment() {

    override fun getViewModelClass(): Class<MoviesListViewModel> =
        PopularMoviesViewModel::class.java as Class<MoviesListViewModel>

    override fun title(): String  = getString(R.string.movies_list_popular_movies_title)

    companion object {

        fun newInstance() : MoviesListFragment {
            val args = Bundle()
            val topRatedMoviesFragment = PopularMoviesListFragment()
            topRatedMoviesFragment.arguments = args
            return topRatedMoviesFragment
        }
    }
}