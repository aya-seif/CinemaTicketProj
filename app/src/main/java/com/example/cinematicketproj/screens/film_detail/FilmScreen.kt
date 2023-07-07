package com.example.cinematicketproj.screens.film_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cinematicketproj.R
import com.example.cinematicketproj.composables.ActorContent
import com.example.cinematicketproj.composables.CancelButton
import com.example.cinematicketproj.composables.ChipDurationView
import com.example.cinematicketproj.composables.RatingRow
import com.example.cinematicketproj.composables.FilmClassificationList
import com.example.cinematicketproj.composables.ShowText
import com.example.cinematicketproj.composables.PlayButtonView
import com.example.cinematicketproj.composables.RoundedOrangeButton
import com.example.cinematicketproj.composables.FilmTitle
import com.example.cinematicketproj.composables.ShowingImage
import com.example.cinematicketproj.ui.theme.Orange
import com.example.cinematicketproj.ui.theme.White

@Composable
fun FilmScreen(
    viewModel: DetailsScreenViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()

    FilmScreenContent(state)

}

@Composable
private fun FilmScreenContent(
    filmDetailUiState: FilmDetailUiState
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
        ) {

            ShowingImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(percentOfScreenHeight(47).dp),
                resId = filmDetailUiState.film.imageRes,
                contentScale = ContentScale.FillBounds
            )

            CancelButton()

            ChipDurationView(
                duration = filmDetailUiState.film.duration, fontColor = White,
                modifier = Modifier
                    .padding(top = 32.dp, end = 16.dp)
                    .align(Alignment.TopEnd)
                    .wrapContentWidth()
                    .background(Color.Transparent, RoundedCornerShape(16.dp))
                    .padding(8.dp)
            )

            PlayButtonView(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
                    .clip(CircleShape)
                    .background(Orange)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(percentOfScreenHeight(percent = 57).dp)
                .align(Alignment.BottomCenter)
                .background(White, RoundedCornerShape(topStart = 34.dp, topEnd = 32.dp))
        ) {

            RatingRow(
                imdbRating = filmDetailUiState.film.imdbRating,
                ignRating = filmDetailUiState.film.ignRating,
                rottenTomatoesRating = filmDetailUiState.film.rottenTomatoesRating
            )

            FilmTitle(
                text = filmDetailUiState.film.name,
            )

            FilmClassificationList(filmDetailUiState.film.classifications)
            ActorContent(filmDetailUiState.film.actors)

            ShowText(filmDetailUiState.film.description)

            RoundedOrangeButton(
                iconId = R.drawable.play,
                textId = R.string.booking,
                onClick = { },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

        }
    }
}


@Composable
fun percentOfScreenHeight(percent: Int): Int {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    return with(LocalDensity.current) {
        (screenHeight * percent / 100)
    }
}

