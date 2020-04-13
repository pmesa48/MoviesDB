package com.pmesa.moviesdb.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.pmesa.moviesdb.model.model.Movie
import com.pmesa.moviesdb.model.usecases.GetTopRatedMoviesUseCase

class TopRatedMoviesViewModel(
    application: Application,
    var getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : MoviesListViewModel(application) {

    override suspend fun find(): List<Movie> = getTopRatedMoviesUseCase.getData()

}