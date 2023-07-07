package com.example.cinematicketproj.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketproj.R
import com.example.cinematicketproj.ui.theme.Open_Sans
import com.example.cinematicketproj.ui.theme.Orange
import com.example.cinematicketproj.ui.theme.TextSmallGreyStyle
import com.example.cinematicketproj.ui.theme.darkGrey
import com.example.cinematicketproj.ui.theme.lightGrey


@Composable
fun BookingStatusRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 24.dp)
            .fillMaxWidth()
    ) {
        BookingStatusItem(text = stringResource(id = R.string.available), color = Color.White)
        BookingStatusItem(text = stringResource(id = R.string.taken), color = darkGrey)
        BookingStatusItem(text = stringResource(id = R.string.selected), color = Orange)
    }
}

@Composable
fun BookingStatusItem(text: String, color: Color) {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(color, CircleShape)
        )
        Text(
            text = text,
            style = TextSmallGreyStyle,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
