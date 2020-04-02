package com.pmesa.moviesdb.model.usecases.common

interface UseCase<T> {

    suspend fun getData() : T

}