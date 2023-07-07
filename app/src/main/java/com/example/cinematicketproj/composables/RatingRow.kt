package com.example.cinematicketproj.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.screens.film_detail.Rating

@Composable
fun RatingRow(
    imdbRating: Rating,
    ignRating: Rating,
    rottenTomatoesRating: Rating
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 28.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        FilmRating(imdbRating)
        FilmRating(ignRating)
        FilmRating(rottenTomatoesRating)
    }
}