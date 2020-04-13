package com.pmesa.moviesdb.model.usecases

import com.pmesa.moviesdb.model.api.movies.MoviesListsApi
import com.pmesa.moviesdb.model.model.Movie

class GetPopularMovies(var api: MoviesListsApi) : GetPopularMoviesUseCase {

    override suspend fun getData(): List<Movie> = api.getPopularList()
}