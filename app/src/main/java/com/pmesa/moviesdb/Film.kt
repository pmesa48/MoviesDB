package com.pmesa.moviesdb

import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("release_date")
    val year: String,
    @SerializedName("title")
    val title: String
)
