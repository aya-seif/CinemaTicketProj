package com.example.cinematicketproj.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.screens.booking.DateUiState
import com.example.cinematicketproj.ui.theme.ChipBackground
import com.example.cinematicketproj.ui.theme.TextLargeBold
import com.example.cinematicketproj.ui.theme.TextSmallGreyStyle
import com.example.cinematicketproj.ui.theme.White
import com.example.cinematicketproj.ui.theme.darkGrey
import com.example.cinematicketproj.ui.theme.lightGrey

@Composable
fun DatePicker(
    list: List<DateUiState>,
    onClick: (Int) -> Unit
) {

    LazyRow(
        modifier = Modifier
            .padding(top = 24.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(list) {
            DateItemView(it, onClick)
        }
    }
}

@Composable
fun DateItemView(
    dateUiState: DateUiState,
    onClick: (Int) -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp)
            .background(
                if (dateUiState.isSelected) ChipBackground else White, RoundedCornerShape(16.dp)
            )
            .clickable { onClick(dateUiState.date) }
            .border(
                width = 1.dp,
                color = if (dateUiState.isSelected) Color.White else Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(6.dp)
            .width(40.dp)
            .height(50.dp)

    ) {
        Text(
            text = dateUiState.date.toString(),
            style = TextLargeBold,
            color = if (dateUiState.isSelected) Color.White else Color.Black,
        )
        Text(
            text = dateUiState.day,
            style = TextSmallGreyStyle,
            color = if (dateUiState.isSelected) Color.White else lightGrey,
        )
    }
}
