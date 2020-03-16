package com.pmesa.moviesdb.model.api.films

import com.pmesa.moviesdb.model.dto.MoviesListsResponseDto
import retrofit2.http.GET

interface MoviesListsApiServices {

    @GET("movie/top_rated")
    suspend fun getTopRatedFilms() : MoviesListsResponseDto

    @GET("movie/upcoming")
    suspend fun getUpcomingFilms(): MoviesListsResponseDto

    @GET("movie/popular")
    suspend fun getPopularFilms(): MoviesListsResponseDto
}
