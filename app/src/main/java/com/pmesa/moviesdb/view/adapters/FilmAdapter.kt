package com.pmesa.moviesdb.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.view.common.inflate
import com.pmesa.moviesdb.model.model.Film
import com.pmesa.moviesdb.view.common.listen
import com.pmesa.moviesdb.view.viewholders.FilmViewHolder

class FilmAdapter(val onItemClick: (Film) -> Unit ): RecyclerView.Adapter<FilmViewHolder>() {

    private var mData : List<Film> = emptyList()

    fun update(it: List<Film>?) {
        it?.let {
            mData = it
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    = FilmViewHolder(parent.inflate(R.layout.top_rated_movie_row))
        .listen { position, _ -> onItemClick(mData[position]) }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(mData[position])
    }

}

