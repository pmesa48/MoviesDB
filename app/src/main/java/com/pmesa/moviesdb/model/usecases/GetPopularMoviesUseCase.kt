package com.pmesa.moviesdb.model.usecases

import com.pmesa.moviesdb.model.model.Movie
import com.pmesa.moviesdb.model.usecases.common.UseCase

interface GetPopularMoviesUseCase :
    UseCase<List<Movie>>