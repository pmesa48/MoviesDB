package com.pmesa.moviesdb

import com.google.gson.annotations.SerializedName

data class GetTopRatedFilmsApiResponse(
    @SerializedName("page")
    val mPage : Int = 0,
    @SerializedName("results")
    val mTopRatedFilms : List<Film>
)