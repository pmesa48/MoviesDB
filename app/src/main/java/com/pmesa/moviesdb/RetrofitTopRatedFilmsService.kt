package com.pmesa.moviesdb

import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitTopRatedFilmsService {

    @GET("movie/top_rated")
    suspend fun getTopRatedFilms(@Query("api_key") token : String) : GetTopRatedFilmsApiResponse
}
