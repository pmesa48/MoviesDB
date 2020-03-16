package com.pmesa.moviesdb.model.api.films

import com.pmesa.moviesdb.model.api.interceptors.ApiKeyInterceptor
import com.pmesa.moviesdb.model.api.interceptors.LanguageInterceptor
import com.pmesa.moviesdb.model.model.Movie
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitMoviesListsApi : MoviesListsApi {

    private val mApi by lazy {
        val retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getHttpClient())
            .build()
        retrofit.create(MoviesListsApiServices::class.java)
    }

    override suspend fun getTopRatedList() =
        mApi.getTopRatedFilms()
            .results
            ?.map { Movie(it) } ?: emptyList()

    override suspend fun getUpcomingList() =
        mApi.getUpcomingFilms()
            .results
            ?.map { Movie(it) } ?: emptyList()


    override suspend fun getPopularList() =
        mApi.getPopularFilms()
            .results
            ?.map{ Movie(it) } ?: emptyList()


    companion object{

        var singleton: RetrofitMoviesListsApi? = null

        private fun getHttpClient(): OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            httpClient.addInterceptor(ApiKeyInterceptor())
            httpClient.addInterceptor(LanguageInterceptor())
            return httpClient.build()
        }

        fun getInstance(): RetrofitMoviesListsApi {
            if(singleton == null){
                singleton =
                    RetrofitMoviesListsApi()
            }
            return singleton as RetrofitMoviesListsApi
        }
    }

}