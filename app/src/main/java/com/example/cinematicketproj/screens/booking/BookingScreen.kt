package com.example.cinematicketproj.screens.booking


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cinematicketproj.R
import com.example.cinematicketproj.composables.BookingStatusRow
import com.example.cinematicketproj.composables.CancelButton
import com.example.cinematicketproj.composables.CinemaSeats
import com.example.cinematicketproj.composables.DatePicker
import com.example.cinematicketproj.composables.RoundedOrangeButton
import com.example.cinematicketproj.composables.ShowingImage
import com.example.cinematicketproj.composables.hourRow
import com.example.cinematicketproj.screens.film_detail.percentOfScreenHeight
import com.example.cinematicketproj.ui.theme.TextXLargeBold
import com.example.cinematicketproj.ui.theme.White
import com.example.cinematicketproj.ui.theme.xSmallTextStyle

@Composable
fun BookingScreen(
    viewModel: BookingViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()
    val pickerState by viewModel.pickerState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        CancelButton()

        ShowingImage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .height(70.dp),
            contentScale = ContentScale.FillBounds,
            resId = R.drawable.dumbldour_secret,
        )

        CinemaSeats(
            viewModel::onSeatClicked,
            viewModel::onSeatClicked,
            state.leftColumns,
            state.centerColumns,
            state.rightColumns
        )

        BookingStatusRow()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(percentOfScreenHeight(percent = 30).dp)
                .background(
                    White, RoundedCornerShape(topStart = 34.dp, topEnd = 32.dp),
                )
        ) {

            DatePicker(list = pickerState, onClick = viewModel::onPickerItemClicked)

            var selectedHour by remember { mutableStateOf(0) }

            hourRow(
                onClick = { hour ->
                    selectedHour = hour
                }, selectedItem = selectedHour
            )

            Row(
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(id = R.string.price_100),
                        style = TextXLargeBold,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .wrapContentSize()
                    )

                    Text(
                        text = stringResource(id = R.string.tickets),
                        style = xSmallTextStyle,
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .wrapContentSize()
                    )
                }

                RoundedOrangeButton(
                    iconId = R.drawable.play,
                    textId = R.string.buy_tickets,
                    onClick = { }
                )
            }

        }

    }
}












