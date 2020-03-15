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
import com.pmesa.moviesdb.model.model.Film
import com.pmesa.moviesdb.view.adapters.FilmAdapter
import com.pmesa.moviesdb.view.common.inflate
import com.pmesa.moviesdb.viewmodel.ViewModelFactory
import com.pmesa.moviesdb.viewmodel.TopRatedMoviesViewModel
import kotlinx.android.synthetic.main.top_rated_movies_fragment.*


class TopRatedMoviesFragment : Fragment() {

    companion object {
        fun newInstance(title: String, type: Int): TopRatedMoviesFragment {
            val args = Bundle()
            args.putString(TITLE, title)
            args.putInt(TYPE, type)
            val topRatedMoviesFragment = TopRatedMoviesFragment()
            topRatedMoviesFragment.arguments = args
            return topRatedMoviesFragment
        }

        private const val TITLE = "title"
        private const val TYPE = "type"

    }

    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var adapter: FilmAdapter

    private lateinit var viewModel: TopRatedMoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = container?.inflate(R.layout.top_rated_movies_fragment)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,
                ViewModelFactory.getInstance(activity!!.application))
            .get(TopRatedMoviesViewModel::class.java)
        adapter = FilmAdapter { startFilmDetailActivity(it) }
        layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        top_rated_films_recycler_view.layoutManager = layoutManager
        top_rated_films_recycler_view.adapter = adapter
        top_rated_film_fragment_title.text = arguments?.getString(TITLE)
        viewModel.getListContent(type(arguments)).observe(viewLifecycleOwner, Observer { refresh(it) })

    }

    private fun type(arguments: Bundle?) = arguments?.let { arguments.getInt(TYPE) } ?: -1

    private fun startFilmDetailActivity(film: Film) {
    }


    private fun refresh(it: List<Film>?) { adapter.update(it) }

}
