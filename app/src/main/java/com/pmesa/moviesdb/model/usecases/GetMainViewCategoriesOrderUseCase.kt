package com.pmesa.moviesdb.model.usecases

import androidx.annotation.IntDef
import com.pmesa.moviesdb.model.model.Movie
import com.pmesa.moviesdb.model.usecases.common.UseCase

interface GetMainViewCategoriesOrderUseCase {

    companion object{
        @IntDef(TOP_RATED, UPCOMING, POPULAR)
        @Retention(AnnotationRetention.SOURCE)
        annotation class ListType

        const val TOP_RATED = 0
        const val UPCOMING = 1
        const val POPULAR = 2
    }

    suspend fun getData(@ListType type: Int = TOP_RATED) : List<Movie>

    fun getOrder() : List<Int>

    class Category(val title: String, val result: List<Movie>)
}