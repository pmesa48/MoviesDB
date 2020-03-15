package com.pmesa.moviesdb.model.dto

import com.google.gson.annotations.SerializedName

data class FilmsListResponseDto(
    @SerializedName("page")
    val page : Int? = 0,
    @SerializedName("results")
    val results : List<FilmDto>? = null,
    @SerializedName("total_results")
    val totalResults : Int = 0,
    @SerializedName("total_pages")
    val totalPages : Int = 0
)