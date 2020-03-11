package com.pmesa.moviesdb


interface TopRatedMoviesApi {
    suspend fun getTopRatedList(): List<Film>
}
