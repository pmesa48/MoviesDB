package com.pmesa.moviesdb.model.api

import com.pmesa.moviesdb.model.dto.TopRatedFilmsResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitTopRatedFilmsService {

    @GET("movie/top_rated")
    suspend fun getTopRatedFilms(@Query("api_key") token : String) : TopRatedFilmsResponseDto
}
