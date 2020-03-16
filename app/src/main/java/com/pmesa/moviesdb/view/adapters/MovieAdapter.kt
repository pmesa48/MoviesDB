package com.pmesa.moviesdb.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.view.common.inflate
import com.pmesa.moviesdb.model.model.Movie
import com.pmesa.moviesdb.view.common.listen
import com.pmesa.moviesdb.view.viewholders.MovieViewHolder

class MovieAdapter(val onItemClick: (Movie) -> Unit ): RecyclerView.Adapter<MovieViewHolder>() {

    private var mData : List<Movie> = emptyList()

    fun update(it: List<Movie>?) {
        it?.let {
            mData = it
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    = MovieViewHolder(parent.inflate(R.layout.top_rated_movie_row))
        .listen { position, _ -> onItemClick(mData[position]) }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(mData[position])
    }

}

