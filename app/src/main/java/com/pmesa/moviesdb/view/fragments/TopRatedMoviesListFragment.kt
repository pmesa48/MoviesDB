package com.pmesa.moviesdb.view.fragments

import android.os.Bundle
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.viewmodel.MoviesListViewModel
import com.pmesa.moviesdb.viewmodel.TopRatedMoviesViewModel

@Suppress("UNCHECKED_CAST")
class TopRatedMoviesListFragment : MoviesListFragment() {

    override fun getViewModelClass(): Class<MoviesListViewModel> =
        TopRatedMoviesViewModel::class.java as Class<MoviesListViewModel>

    override fun title(): String  = getString(R.string.movies_list_top_rated_title)

    companion object {

        fun newInstance() : MoviesListFragment {
            val args = Bundle()
            val topRatedMoviesFragment = TopRatedMoviesListFragment()
            topRatedMoviesFragment.arguments = args
            return topRatedMoviesFragment
        }
    }
}