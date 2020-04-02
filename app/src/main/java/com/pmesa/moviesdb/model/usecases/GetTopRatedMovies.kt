package com.pmesa.moviesdb.model.usecases

import com.pmesa.moviesdb.model.api.movies.MoviesListsApi

class GetTopRatedMovies(var api: MoviesListsApi) : GetTopRatedMoviesUseCase {

    override suspend fun getData() = api.getTopRatedList()
}