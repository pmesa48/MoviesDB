package com.pmesa.moviesdb.viewmodel

import android.app.Application
import androidx.annotation.IntDef
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.pmesa.moviesdb.model.api.films.MoviesListsApi
import kotlinx.coroutines.Dispatchers


class MoviesListsViewModel(app: Application, private val api: MoviesListsApi) : AndroidViewModel(app) {

    fun getListContent(type: Int) =
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
