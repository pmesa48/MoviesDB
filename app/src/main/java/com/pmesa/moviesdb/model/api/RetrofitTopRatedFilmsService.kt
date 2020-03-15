package com.pmesa.moviesdb.model.api

import com.pmesa.moviesdb.model.dto.FilmsListResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitTopRatedFilmsService {

    @GET("movie/top_rated")
    suspend fun getTopRatedFilms() : FilmsListResponseDto

    @GET("movie/upcoming")
    suspend fun getUpcomingFilms(): FilmsListResponseDto

    @GET("movie/popular")
    suspend fun getPopularFilms(): FilmsListResponseDto
}
