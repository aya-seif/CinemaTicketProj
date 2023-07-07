package com.example.cinematicketproj.screens.home

import com.example.cinematicketproj.screens.film_detail.FilmClassification

data class HomeUiState(
    val filmList: List<Int> = emptyList(),
    val filmClassifications: List<FilmClassification> = emptyList(),
    val filmName: String = "",
    val filmDuration: String = ""
)
