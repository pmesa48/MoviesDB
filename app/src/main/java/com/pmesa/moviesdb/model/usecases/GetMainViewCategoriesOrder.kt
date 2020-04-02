package com.pmesa.moviesdb.model.usecases

import com.pmesa.moviesdb.model.model.Movie

class GetMainViewCategoriesOrder(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : GetMainViewCategoriesOrderUseCase {

    override suspend fun getData(type: Int): List<Movie> =
        when(type){
            GetMainViewCategoriesOrderUseCase.POPULAR -> getPopularMoviesUseCase.getData()
            GetMainViewCategoriesOrderUseCase.UPCOMING -> getUpcomingMoviesUseCase.getData()
            else -> getTopRatedMoviesUseCase.getData()
        }

    override fun getOrder() = listOf(
        GetMainViewCategoriesOrderUseCase.POPULAR,
        GetMainViewCategoriesOrderUseCase.UPCOMING,
        GetMainViewCategoriesOrderUseCase.TOP_RATED
    )
}