package com.pmesa.moviesdb.model.dto

import com.google.gson.annotations.SerializedName

data class TopRatedFilmsResponseDto(
    @SerializedName("page")
    val page : Int = 0,
    @SerializedName("results")
    val topRatedFilms : List<FilmDto>,
    @SerializedName("total_results")
    val totalResults : Int,
    @SerializedName("total_pages")
    val totalPages : Int
)