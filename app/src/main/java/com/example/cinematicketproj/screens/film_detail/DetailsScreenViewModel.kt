package com.example.cinematicketproj.screens.film_detail


import androidx.lifecycle.ViewModel
import com.example.cinematicketproj.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(FilmDetailUiState())
    val state = _state.asStateFlow()

    init {
        getActors()
    }

    private fun getActors() {
        val actors = listOf(
            Actor(R.drawable.img1),
            Actor(R.drawable.img2),
            Actor(R.drawable.img3),
            Actor(R.drawable.img4),
            Actor(R.drawable.img6),
            Actor(R.drawable.img7),
            Actor(R.drawable.img2),
        )
        val imdbValue = "8.5"
        val imdbMaxValue = "10"
        val imdb = "IMDB"
        val rottenTomatoesValue = "63%"
        val rottenTomatoes = "Rotten Tomatoes"
        val ignValue = "4"
        val ignMaxValue = "10"
        val ign = "IGN"
        val ignRating = Rating(ignValue, ign, ignMaxValue)
        val imdbRating = Rating(imdbValue, imdb, imdbMaxValue)
        val rottenTomatoesRating = Rating(rottenTomatoesValue, rottenTomatoes)
        val filmName = " Fantastic Beats : The\nSecret Of Dumbledore"
        val filmImage = R.drawable.poster
        val filmDuration = "2h 23m"
        val description = "Professor Albus Dumbledore knows the powerful Dark" +
                "wizard Gellert Grindelwald is moving to seize control of" +
                "the wizarding world. Unable to stop him alone, he entrusts" +
                "Magizoologist Newt Scamander to lead an intrepid team of wizards," +
                "witches and one brave Muggle baker on a dangerous mission, where" +
                "they encounter old and new beasts and clash with Grindelwald's" +
                "growing legion of followers. But with the stakes so high, how long" +
                "can Dumbledore remain on the sidelines?"

        val filmClassifications = listOf(
            FilmClassification("Fantasy"),
            FilmClassification("Adventure")
        )

        val film = Film(
            filmName,
            filmImage,
            filmDuration,
            description,
            imdbRating,
            ignRating,
            rottenTomatoesRating,
            actors,
            filmClassifications
        )

        _state.update {
            it.copy(film = film)
        }
    }
}