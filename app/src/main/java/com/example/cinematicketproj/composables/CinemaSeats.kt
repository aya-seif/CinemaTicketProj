package com.example.cinematicketproj.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketproj.R
import com.example.cinematicketproj.screens.BookingUiStateItem
import com.example.cinematicketproj.screens.SeatStatus
import com.example.cinematicketproj.ui.theme.Orange
import com.example.cinematicketproj.ui.theme.White
import com.example.cinematicketproj.ui.theme.darkGrey


@Composable
fun CinemaSeats(
    onClickFirstSeat: (BookingUiStateItem) -> Unit,
    onClickSecondSecond: (BookingUiStateItem) -> Unit,
    columnLeftSeats: List<Pair<BookingUiStateItem, BookingUiStateItem>>,
    columnCenterSeats: List<Pair<BookingUiStateItem, BookingUiStateItem>>,
    columnRightSeats: List<Pair<BookingUiStateItem, BookingUiStateItem>>,
) {
    Row(
        modifier = Modifier
            .padding(
                end = 10.dp,
                top = 32.dp,
            ),
    ) {
        SeatsColumn(rotationAngle = 8f, columnLeftSeats, onClickFirstSeat, onClickSecondSecond)
        SeatsColumn(rotationAngle = 0f, columnCenterSeats, onClickFirstSeat, onClickSecondSecond)
        SeatsColumn(rotationAngle = -8f, columnRightSeats, onClickFirstSeat, onClickSecondSecond)
    }
}

@Composable
fun SeatsColumn(
    rotationAngle: Float,
    list: List<Pair<BookingUiStateItem, BookingUiStateItem>>,
    onClickFirst: (BookingUiStateItem) -> Unit,
    onClickSecond: (BookingUiStateItem) -> Unit,
) {
    LazyColumn {
        items(list) {
            SeatsRaw(modifier = Modifier.rotate(rotationAngle), it, onClickFirst, onClickSecond)
        }
    }
}

@Composable
fun SeatsRaw(
    modifier: Modifier,
    seat: Pair<BookingUiStateItem, BookingUiStateItem>,
    onClickFirstSeat: (BookingUiStateItem) -> Unit,
    onClickSecondSecond: (BookingUiStateItem) -> Unit,
) {

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.size(height = 40.dp, width = 120.dp),
            painter = painterResource(id = R.drawable.chair_container),
            contentDescription = ""
        )

        Row(
        ) {
            SeatIcon(seat.first, onClickFirstSeat)
            SeatIcon(seat.second, onClickSecondSecond)
        }

    }
}

@Composable
fun SeatIcon(
    bookingUiStateItem: BookingUiStateItem,
    onClick: (BookingUiStateItem) -> Unit
) {

    val color = when (bookingUiStateItem.status) {
        SeatStatus.SELECTED -> White
        SeatStatus.AVAILABLE -> Orange
        SeatStatus.TAKEN -> darkGrey
    }

    Icon(
        modifier = Modifier
            .padding(start = 2.dp, bottom = 8.dp)
            .size(40.dp)
            .clickable { onClick(bookingUiStateItem) },
        painter = painterResource(id = R.drawable.seat),
        contentDescription = "",
        tint = color
    )

}