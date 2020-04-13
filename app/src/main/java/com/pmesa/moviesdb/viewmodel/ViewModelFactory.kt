package com.pmesa.moviesdb.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pmesa.moviesdb.model.api.movies.RetrofitMoviesListsApi
import com.pmesa.moviesdb.model.usecases.GetPopularMovies
import com.pmesa.moviesdb.model.usecases.GetTopRatedMovies
import com.pmesa.moviesdb.model.usecases.GetUpcomingMovies

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val app: Application)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(PopularMoviesViewModel::class.java) -> {
                PopularMoviesViewModel(
                    app,
                    GetPopularMovies(RetrofitMoviesListsApi())
                ) as T
            }
            modelClass.isAssignableFrom(TopRatedMoviesViewModel::class.java) -> {
                TopRatedMoviesViewModel(
                    app,
                    GetTopRatedMovies(RetrofitMoviesListsApi())
                ) as T
            }
            modelClass.isAssignableFrom(UpcomingMoviesListViewModel::class.java) -> {
                UpcomingMoviesListViewModel(
                    app, GetUpcomingMovies(RetrofitMoviesListsApi())
                ) as T
            }
            else -> {
                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }


    companion object{

        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory {
            return INSTANCE
                ?: synchronized(
                ViewModelFactory::class.java) {
                ViewModelFactory(
                        application
                    )
                    .also { INSTANCE = it }
            }
        }
    }
}