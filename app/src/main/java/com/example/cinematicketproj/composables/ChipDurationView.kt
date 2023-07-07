package com.example.cinematicketproj.composables


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.R
import com.example.cinematicketproj.ui.theme.MediumTextStyle
import com.example.cinematicketproj.ui.theme.White

@Composable
fun ChipDurationView(
    duration: String,
    fontColor: Color,
    modifier: Modifier,
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* Do something */ },
            modifier = Modifier
                .size(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.hour),
                contentDescription = "",
                tint = White
            )
        }
        Text(
            duration,
            style = MediumTextStyle,
            color = fontColor,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}