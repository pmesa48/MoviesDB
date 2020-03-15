package com.pmesa.moviesdb.view.viewholders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.model.model.Film
import com.pmesa.moviesdb.view.common.RoundedTransformation
import com.squareup.picasso.Picasso


class FilmViewHolder(view: View): RecyclerView.ViewHolder(view)  {
    private val mBackgroundImage
            by lazy { itemView.findViewById<ImageView>(R.id.top_rated_movie_image_background) }

    fun bind(film: Film) {
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w200${film.posterPath}")
            .transform(RoundedTransformation(8, 0))
            .into(mBackgroundImage)
    }

}
