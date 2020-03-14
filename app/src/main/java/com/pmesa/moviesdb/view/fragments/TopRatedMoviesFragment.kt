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
import com.pmesa.moviesdb.model.model.Film
import com.pmesa.moviesdb.view.adapters.FilmAdapter
import com.pmesa.moviesdb.viewmodel.ViewModelFactory
import com.pmesa.moviesdb.viewmodel.TopRatedMoviesViewModel
import kotlinx.android.synthetic.main.top_rated_movies_fragment.*


class TopRatedMoviesFragment : Fragment() {

    companion object {
        fun newInstance() =
            TopRatedMoviesFragment()
    }

    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var adapter: FilmAdapter

    private lateinit var viewModel: TopRatedMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.top_rated_movies_fragment, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,
                ViewModelFactory.getInstance(activity!!.application))
            .get(TopRatedMoviesViewModel::class.java)
        adapter = FilmAdapter { startFilmDetailActivity(it) }
        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        top_rated_films_recycler_view.layoutManager = layoutManager
        top_rated_films_recycler_view.adapter = adapter
        viewModel.mTopRatedMoviesList.observe(viewLifecycleOwner, Observer { refresh(it) })

    }

    private fun startFilmDetailActivity(film: Film) {
    }


    private fun refresh(it: List<Film>?) {
        adapter.update(it)
    }

}
