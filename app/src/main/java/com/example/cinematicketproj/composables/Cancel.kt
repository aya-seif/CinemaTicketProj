package com.example.cinematicketproj.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.R
import com.example.cinematicketproj.ui.theme.lightBlack

@Composable
fun CancelButton() {
    Box(
        modifier = Modifier
            .padding(top = 32.dp, start = 16.dp)
            .size(36.dp)
            .background(lightBlack, CircleShape)
            .padding(8.dp)
            .border(1.dp, White, CircleShape)
            .padding(4.dp)
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.Center)
                .size(14.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cancel),
                contentDescription = "",
                tint = White
            )
        }
    }
}