package com.pmesa.moviesdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.pmesa.moviesdb.model.model.Movie
import kotlinx.coroutines.Dispatchers

abstract class MoviesListViewModel(app: Application) : AndroidViewModel(app){

    abstract suspend fun find(): List<Movie>

    fun data(): LiveData<Response> =
        liveData(Dispatchers.IO) {
            emit(Response.InProgress)
            val result = find()
            emit(Response.Success(result))
        }

    sealed class Response {
        data class Success(val results: List<Movie>) : Response()
        object Failure : Response()
        object InProgress : Response()
    }
}
