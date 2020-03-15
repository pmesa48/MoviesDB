package com.pmesa.moviesdb.viewmodel

import android.app.Application
import androidx.annotation.IntDef
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.pmesa.moviesdb.model.api.TopRatedMoviesApi
import com.pmesa.moviesdb.model.model.Film
import kotlinx.coroutines.Dispatchers


class TopRatedMoviesViewModel(app: Application, private val api: TopRatedMoviesApi) : AndroidViewModel(app) {

    fun getListContent(type: Int) : LiveData<List<Film>>  =
        liveData(Dispatchers.IO) {
            emit(
                when(type) {
                    TOP_RATED -> api.getTopRatedList()
                    UPCOMING -> api.getUpcomingList()
                    else -> api.getPopularList()
                })
        }

    companion object{
        @IntDef(TOP_RATED, UPCOMING, POPULAR)
        @Retention(AnnotationRetention.SOURCE)
        annotation class ListType

        const val TOP_RATED = 0
        const val UPCOMING = 1
        const val POPULAR = 2
    }
}
