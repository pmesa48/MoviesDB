package com.pmesa.moviesdb.viewmodel

import android.app.Application
import com.pmesa.moviesdb.model.model.Movie
import com.pmesa.moviesdb.model.usecases.GetUpcomingMoviesUseCase

class UpcomingMoviesListViewModel(
    application: Application,
    var getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
) : MoviesListViewModel(application) {

    override suspend fun find(): List<Movie> = getUpcomingMoviesUseCase.getData()
}