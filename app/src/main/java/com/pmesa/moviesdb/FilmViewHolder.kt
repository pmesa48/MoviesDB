package com.pmesa.moviesdb

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmViewHolder(view: View): RecyclerView.ViewHolder(view)  {

    private val mTitle : TextView by lazy { itemView.findViewById<TextView>(R.id.top_rated_film_title_text_view) }

    private val mYear: TextView by lazy { itemView.findViewById<TextView>(R.id.top_rated_film_year_text_view) }

    fun bind(film: Film) {
        mTitle.text = film.title
        mYear.text = film.year
    }

}
