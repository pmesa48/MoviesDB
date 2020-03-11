package com.pmesa.moviesdb

import retrofit2.Retrofit

class TopRatedFilmsRepository(retrofit: Retrofit) {

    var client = retrofit.create(RetrofitTopRatedFilmsService::class.java)

    //simplified version of the retrofit call that comes from support with coroutines
    //Note that this does NOT handle errors, to be added
    suspend fun getData(token : String) = client.getTopRatedFilms(token)

}