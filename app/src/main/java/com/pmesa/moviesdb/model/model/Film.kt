package com.pmesa.moviesdb.model.model

import com.pmesa.moviesdb.model.dto.FilmDto


data class Film(
    val year: String,
    val title: String,
    val originalTitle: String,
    val posterPath: String,
    val voteAverage: Double
){
    constructor(dto: FilmDto)
            : this(dto.releaseDate, dto.title, dto.originalTitle, dto.posterPath, dto.voteAverage)
}
