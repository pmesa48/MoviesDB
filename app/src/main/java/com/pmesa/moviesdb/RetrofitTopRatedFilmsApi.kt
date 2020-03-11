package com.pmesa.moviesdb

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTopRatedFilmsApi(retrofit: Retrofit) : TopRatedMoviesApi{

    private val mApi = retrofit.create(RetrofitTopRatedFilmsService::class.java)

    override suspend fun getTopRatedList() =
        mApi.getTopRatedFilms("ac9fd208182cbbc4f327f27f7318183f").mTopRatedFilms

    companion object{

        var singleton: RetrofitTopRatedFilmsApi? = null

        private fun getHttpClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            return httpClient.build()
        }

        fun getInstance(): RetrofitTopRatedFilmsApi {
            if(singleton == null){
                singleton = RetrofitTopRatedFilmsApi(
                    Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient())
                    .build())
            }
            return singleton as RetrofitTopRatedFilmsApi
        }
    }

}