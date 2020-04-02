package com.pmesa.moviesdb.viewmodel

import android.app.Application
import androidx.annotation.IntDef
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.pmesa.moviesdb.model.model.Movie
import com.pmesa.moviesdb.model.usecases.GetMainViewCategoriesOrderUseCase
import com.pmesa.moviesdb.model.usecases.GetPopularMovies
import com.pmesa.moviesdb.model.usecases.GetTopRatedMovies
import com.pmesa.moviesdb.model.usecases.GetUpcomingMovies
import kotlinx.coroutines.Dispatchers


class MoviesListsViewModel(
    app: Application,
    private val getMainViewCategoriesOrderUseCase: GetMainViewCategoriesOrderUseCase
) : AndroidViewModel(app) {

    fun getListContent(type: Int) =
        liveData(Dispatchers.IO) {
            emit(ViewModelResponse.InProgress)
            val result = getMainViewCategoriesOrderUseCase.getData(type)
            emit(
                if(result.isEmpty()) ViewModelResponse.Failure
                else ViewModelResponse.Success(result)
            )
        }

    sealed class ViewModelResponse {
        data class Success(val results: List<Movie>) : ViewModelResponse()
        object Failure : ViewModelResponse()
        object InProgress : ViewModelResponse()
    }
}
