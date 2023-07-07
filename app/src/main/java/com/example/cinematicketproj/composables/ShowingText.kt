package com.example.cinematicketproj.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.ui.theme.OnBackGround
import com.example.cinematicketproj.ui.theme.TextSmallGreyStyle

@Composable
fun ShowText(text: String) {
    Text(
        modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
        text = text,
        maxLines = 3,
        style = TextSmallGreyStyle,
        color = OnBackGround,
    )
}