package com.example.cinematicketproj.screens


data class BookingUiState(
    val leftColumns: List<Pair<BookingUiStateItem, BookingUiStateItem>> = emptyList(),
    val centerColumns: List<Pair<BookingUiStateItem, BookingUiStateItem>> = emptyList(),
    val rightColumns: List<Pair<BookingUiStateItem, BookingUiStateItem>> = emptyList(),
)

data class BookingUiStateItem(
    val id: Int = 0,
    val status: SeatStatus = SeatStatus.AVAILABLE,
)

enum class SeatStatus {
    SELECTED, AVAILABLE, TAKEN
}