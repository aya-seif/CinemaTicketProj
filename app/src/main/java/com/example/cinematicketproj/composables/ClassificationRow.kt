package com.example.cinematicketproj.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketproj.screens.film_detail.FilmClassification
import com.example.cinematicketproj.ui.theme.OnBackGround
import com.example.cinematicketproj.ui.theme.OnPrimary
import com.example.cinematicketproj.ui.theme.TextSmallGreyStyle
import com.example.cinematicketproj.ui.theme.lightBlack
import com.example.cinematicketproj.ui.theme.lightGrey
import com.example.cinematicketproj.ui.theme.primaryTextColor


@Composable
fun FilmClassificationList(filmClassifications: List<FilmClassification>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(2.dp)
    ) {

        items(filmClassifications) { filmClassification ->
            FilmClassificationItem(filmClassification)
        }
    }
}

@Composable
private fun FilmClassificationItem(
    filmClassification: FilmClassification
) {
    Chip(title = filmClassification.title)
}

@Composable
private fun Chip(
    title: String
) {
    Text(
        text = title,
        style = TextSmallGreyStyle,
        color = OnBackGround,
        modifier = Modifier
            .wrapContentWidth()
            .padding(1.dp)
            .border(BorderStroke(1.dp, lightGrey), RoundedCornerShape(16.dp))
            .padding(vertical = 4.dp, horizontal = 8.dp)
    )
}