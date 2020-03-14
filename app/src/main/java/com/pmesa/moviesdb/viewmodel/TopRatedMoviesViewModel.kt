package com.pmesa.moviesdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.pmesa.moviesdb.model.api.TopRatedMoviesApi
import com.pmesa.moviesdb.model.model.Film
import kotlinx.coroutines.Dispatchers


class TopRatedMoviesViewModel(app: Application, api: TopRatedMoviesApi) : AndroidViewModel(app) {

    val mTopRatedMoviesList : LiveData<List<Film>> =
        liveData(Dispatchers.IO){ emit(api.getTopRatedList()) }

}
