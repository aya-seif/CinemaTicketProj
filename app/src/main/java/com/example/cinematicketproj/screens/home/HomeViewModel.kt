package com.example.cinematicketproj.screens.home

import androidx.lifecycle.ViewModel
import com.example.cinematicketproj.R
import com.example.cinematicketproj.screens.film_detail.FilmClassification
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {

        val filmList = listOf(
            R.drawable.poster1,
            R.drawable.poster2,
            R.drawable.poster3,
        )
        val filmDuration = "2h 23m"
        val filmName = " Fantastic Beats : The\nSecret Of Dumbledore"
        val filmClassifications = listOf(
            FilmClassification("Fantasy"),
            FilmClassification("Adventure")
        )


        _state.update {
            it.copy(
                filmList = filmList,
                filmDuration = filmDuration,
                filmName = filmName,
                filmClassifications = filmClassifications
            )
        }
    }
}