package com.pmesa.moviesdb.model.api.films

import com.pmesa.moviesdb.model.model.Movie


interface MoviesListsApi {
    suspend fun getTopRatedList(): List<Movie>
    suspend fun getUpcomingList(): List<Movie>
    suspend fun getPopularList(): List<Movie>

}
