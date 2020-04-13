package com.pmesa.moviesdb.viewmodel

import android.app.Application
import com.pmesa.moviesdb.model.usecases.GetPopularMoviesUseCase

class PopularMoviesViewModel(
    application: Application,
    var getPopularMoviesUseCase: GetPopularMoviesUseCase
) : MoviesListViewModel(application) {

    override suspend fun find() = getPopularMoviesUseCase.getData()

}