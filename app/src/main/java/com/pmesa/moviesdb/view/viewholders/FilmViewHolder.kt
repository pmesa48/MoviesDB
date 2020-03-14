package com.pmesa.moviesdb.view.viewholders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.pmesa.moviesdb.R
import com.pmesa.moviesdb.model.model.Film
import com.pmesa.moviesdb.view.common.RoundedTransformation
import com.squareup.picasso.Picasso


class FilmViewHolder(view: View): RecyclerView.ViewHolder(view)  {
    private val mBackgroundImage: ImageView by lazy { itemView.findViewById<ImageView>(R.id.top_rated_movie_image_background) }

    fun bind(film: Film) {
        Picasso.get().isLoggingEnabled = true
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w200${film.posterPath}")
            .transform(
                RoundedTransformation(
                    16,
                    0
                )
            )
            .into(mBackgroundImage)
    }

}
