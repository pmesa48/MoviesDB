package com.pmesa.moviesdb.model.api

import com.pmesa.moviesdb.model.api.interceptors.ApiKeyInterceptor
import com.pmesa.moviesdb.model.model.Film
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitTopRatedFilmsApi(retrofit: Retrofit) :
    TopRatedMoviesApi {

    private val mApi by lazy { retrofit.create(RetrofitTopRatedFilmsService::class.java) }

    override suspend fun getTopRatedList() =
        mApi.getTopRatedFilms()
            .results
            ?.map { Film(it) } ?: emptyList()

    override suspend fun getUpcomingList() =
        mApi.getUpcomingFilms()
            .results
            ?.map { Film(it) } ?: emptyList()


    override suspend fun getPopularList() =
        mApi.getPopularFilms()
            .results
            ?.map{ Film(it) } ?: emptyList()


    companion object{

        var singleton: RetrofitTopRatedFilmsApi? = null

        private fun getHttpClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            httpClient.addInterceptor(ApiKeyInterceptor())
            return httpClient.build()
        }

        fun getInstance(): RetrofitTopRatedFilmsApi {
            if(singleton == null){
                singleton =
                    RetrofitTopRatedFilmsApi(
                        Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(getHttpClient())
                            .build()
                    )
            }
            return singleton as RetrofitTopRatedFilmsApi
        }
    }

}