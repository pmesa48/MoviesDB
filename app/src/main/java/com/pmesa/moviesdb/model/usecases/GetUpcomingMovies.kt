package com.pmesa.moviesdb.model.usecases

import com.pmesa.moviesdb.model.api.movies.MoviesListsApi
import com.pmesa.moviesdb.model.model.Movie

class GetUpcomingMovies(val api: MoviesListsApi) : GetUpcomingMoviesUseCase {

    override suspend fun getData(): List<Movie> = api.getUpcomingList()
}