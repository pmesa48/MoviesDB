package com.pmesa.moviesdb.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.model.model.Movie
import com.pmesa.moviesdb.view.adapters.MovieAdapter
import com.pmesa.moviesdb.view.common.*
import com.pmesa.moviesdb.viewmodel.ViewModelFactory
import com.pmesa.moviesdb.viewmodel.MoviesListsViewModel
import kotlinx.android.synthetic.main.top_rated_movies_fragment.*


class MoviesListFragment : Fragment() {

    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var adapter: MovieAdapter

    private lateinit var viewModel: MoviesListsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = container?.inflate(R.layout.top_rated_movies_fragment)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,
                ViewModelFactory.getInstance(activity!!.application))
            .get(MoviesListsViewModel::class.java)
        adapter = MovieAdapter { startFilmDetailActivity(it) }
        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        top_rated_films_recycler_view.layoutManager = layoutManager
        top_rated_films_recycler_view.adapter = adapter
        top_rated_film_fragment_title.text = arguments?.getString(TITLE)
        viewModel.getListContent(type(arguments))
            .observe(viewLifecycleOwner, Observer { refresh(it) })

    }

    private fun type(arguments: Bundle?) = arguments?.let { arguments.getInt(TYPE) } ?: -1

    private fun startFilmDetailActivity(movie: Movie) {
    }


    private fun refresh(it: MoviesListsViewModel.ViewModelResponse) {
        when(it){
            is MoviesListsViewModel.ViewModelResponse.InProgress -> showProgress()
            is MoviesListsViewModel.ViewModelResponse.Success -> updateContent(it)
            is MoviesListsViewModel.ViewModelResponse.Failure -> hideContent()
        }
    }

    private fun updateContent(it: MoviesListsViewModel.ViewModelResponse.Success) {
        top_rated_films_recycler_view.makeVisible()
        adapter.update(it.results)
    }

    private fun hideContent() {
        top_rated_films_recycler_view.makeGone()
    }

    private fun showProgress() {

    }

    companion object {

        private const val TITLE = "title"

        private const val TYPE = "type"

        fun newInstance(title: String, type: Int): MoviesListFragment {
            val args = Bundle()
            args.putString(TITLE, title)
            args.putInt(TYPE, type)
            val topRatedMoviesFragment = MoviesListFragment()
            topRatedMoviesFragment.arguments = args
            return topRatedMoviesFragment
        }
    }

}
