package com.example.cinematicketproj.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cinematicketproj.screens.film_detail.Rating
import com.example.cinematicketproj.ui.theme.MediumTextStyle
import com.example.cinematicketproj.ui.theme.lightGrey
import com.example.cinematicketproj.ui.theme.primaryTextColor

@Composable
fun FilmRating(
    rating: Rating
) {
    Column() {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = rating.value,
                style = MediumTextStyle,
                color = primaryTextColor,
            )
            if (rating.max != "") {
                TextMediumLightGrey(text = "/${rating.max}")
            }
        }

        TextMediumLightGrey(text = rating.name)
    }
}

@Composable
fun TextMediumLightGrey(text: String) {

    Text(
        text = text,
        style = MediumTextStyle,
        color = lightGrey,
    )
}