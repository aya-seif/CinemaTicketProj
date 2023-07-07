package com.example.cinematicketproj.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.screens.film_detail.percentOfScreenHeight

@Composable
fun PosterImage(imageRes: Int) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(percentOfScreenHeight(47).dp),
        painter = painterResource(id = imageRes),
        contentDescription = "",
        contentScale = ContentScale.Crop,
    )

}

@Composable
fun ShowingImage(
    modifier: Modifier,
    resId: Int,
    contentScale: ContentScale
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = resId),
        contentDescription = "",
        contentScale = contentScale
    )
}