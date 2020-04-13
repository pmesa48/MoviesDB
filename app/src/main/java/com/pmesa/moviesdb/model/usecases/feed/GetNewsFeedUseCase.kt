package com.pmesa.moviesdb.model.usecases.feed

import com.pmesa.moviesdb.model.model.Movie

interface GetNewsFeedUseCase {

    suspend fun find(): List<Movie>

}