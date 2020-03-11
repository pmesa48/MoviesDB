package com.pmesa.moviesdb

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FilmAdapter: RecyclerView.Adapter<FilmViewHolder>() {

    private var mData : List<Film> = emptyList()

    fun refreshData(it: List<Film>?) {
        it?.let {
            mData = it
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder
    = FilmViewHolder(parent.inflateForViewHolder(R.layout.top_rated_movie_row))

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(mData[position])
    }

}

