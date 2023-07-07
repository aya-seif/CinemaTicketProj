package com.example.cinematicketproj.screens.film_detail


data class Film(
    val name: String = "",
    val imageRes: Int = 0,
    val duration: String = "",
    val description: String = "",
    val imdbRating: Rating = Rating(),
    val rottenTomatoesRating: Rating = Rating(),
    val ignRating: Rating = Rating(),
    val actors: List<Actor> = emptyList(),
    val classifications: List<FilmClassification> = emptyList(),

    )

data class Rating(
    val value: String = "",
    val name: String = "",
    val max: String = ""
)

data class Actor(
    val imageRes: Int = 0,
)

data class FilmDetailUiState(
    val film: Film = Film()
)