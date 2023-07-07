package com.example.cinematicketproj.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.ui.theme.TextXLargeBold
import com.example.cinematicketproj.ui.theme.primaryTextColor

@Composable
fun FilmTitle(
    text: String
) {
    Box(
        modifier = Modifier
            .padding(top=16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextXLargeBold,
            color = primaryTextColor,
        )
    }
}