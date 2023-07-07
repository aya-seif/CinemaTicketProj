package com.example.cinematicketproj.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.ui.theme.ChipBackground
import com.example.cinematicketproj.ui.theme.TextSmallGreyStyle
import com.example.cinematicketproj.ui.theme.White
import com.example.cinematicketproj.ui.theme.darkGrey
import com.example.cinematicketproj.ui.theme.lightGrey

@Composable
fun hourRow(
    onClick: (Int) -> Unit,
    selectedItem: Int
) {
    val hours = (0..23).toList()

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        items(hours) { hour ->
            hourItemView(hour, onClick, hour == selectedItem)
        }
    }
}

@Composable
fun hourItemView(
    hour: Int,
    onClick: (Int) -> Unit,
    isSelected: Boolean
) {
    val formattedHour = "%02d:00".format(hour)

    Text(
        text = formattedHour,
        style = TextSmallGreyStyle,
        color = if (isSelected) Color.White else Color.Black,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(
                width = 1.dp,
                color = if (isSelected) ChipBackground else Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            )
            .background(
                if (isSelected) ChipBackground else White,
                RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable { onClick(hour) }

    )
}