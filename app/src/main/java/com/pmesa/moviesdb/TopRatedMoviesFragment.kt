package com.pmesa.moviesdb

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.top_rated_movies_fragment.*


class TopRatedMoviesFragment : Fragment() {

    companion object {
        fun newInstance() = TopRatedMoviesFragment()
    }

    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var dataAdapter: FilmAdapter

    private lateinit var viewModel: TopRatedMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.top_rated_movies_fragment, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, ViewModelFactory.getInstance(activity!!.application))
            .get(TopRatedMoviesViewModel::class.java)
        dataAdapter = FilmAdapter()
        layoutManager = LinearLayoutManager(context)
        top_rated_films_recycler_view.layoutManager = layoutManager
        top_rated_films_recycler_view.adapter = dataAdapter
        viewModel.mTopRatedMoviesList.observe(viewLifecycleOwner, Observer {
            refreshUiData(it)
        })

    }


    private fun refreshUiData(it: List<Film>?) {
        dataAdapter.refreshData(it)
    }

}
