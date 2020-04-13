package com.pmesa.moviesdb.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.model.model.Movie
import com.pmesa.moviesdb.view.adapters.MovieAdapter
import com.pmesa.moviesdb.view.common.*
import com.pmesa.moviesdb.viewmodel.MoviesListViewModel
import com.pmesa.moviesdb.viewmodel.MoviesListViewModel.*
import com.pmesa.moviesdb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.movies_list_fragment.*


abstract class MoviesListFragment: Fragment() {

    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var adapter: MovieAdapter

    private lateinit var viewModelPlugin: MoviesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = container?.inflate(R.layout.movies_list_fragment)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelPlugin = ViewModelProviders.of(this,
                ViewModelFactory.getInstance(activity!!.application))
            .get(getViewModelClass())
        adapter = MovieAdapter { startFilmDetailActivity(it) }
        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        movies_list_recycler_view.layoutManager = layoutManager
        movies_list_recycler_view.adapter = adapter
        movies_list_fragment_title.text = arguments?.getString(title())
        movies_list_shimmer_layout.startShimmer()
        viewModelPlugin.data().observe(viewLifecycleOwner, Observer { refresh(it) })
    }

    abstract fun getViewModelClass(): Class<MoviesListViewModel>

    abstract fun title(): String

    private fun startFilmDetailActivity(movie: Movie) {

    }


    private fun refresh(it: Response) {
        when(it){
            is Response.InProgress -> showProgress()
            is Response.Success -> updateContent(it)
            is Response.Failure -> hideContent()
        }
    }

    private fun updateContent(it: Response.Success) {
        movies_list_shimmer_layout.hideShimmer()
        movies_list_recycler_view.makeVisible()
        adapter.update(it.results)
    }

    private fun hideContent() {
        movies_list_shimmer_layout.hideShimmer()
        movies_list_recycler_view.makeGone()
    }

    private fun showProgress() {
        movies_list_shimmer_layout.startShimmer()
        movies_list_recycler_view.makeInvisible()
    }
}
