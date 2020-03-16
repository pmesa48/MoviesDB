package com.pmesa.moviesdb.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pmesa.moviesdb.model.api.films.RetrofitMoviesListsApi

class ViewModelFactory(private val app: Application)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MoviesListsViewModel::class.java)) {
            MoviesListsViewModel(
                app,
                RetrofitMoviesListsApi.getInstance()
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
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