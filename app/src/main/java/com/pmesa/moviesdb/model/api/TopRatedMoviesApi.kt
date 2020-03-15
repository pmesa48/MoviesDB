package com.pmesa.moviesdb.model.api

import com.pmesa.moviesdb.model.model.Film


interface TopRatedMoviesApi {
    suspend fun getTopRatedList(): List<Film>
    suspend fun getUpcomingList(): List<Film>
    suspend fun getPopularList(): List<Film>

}
