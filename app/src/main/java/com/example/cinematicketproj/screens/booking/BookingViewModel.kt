package com.example.cinematicketproj.screens.booking

import androidx.lifecycle.ViewModel
import com.example.cinematicketproj.screens.BookingUiState
import com.example.cinematicketproj.screens.BookingUiStateItem
import com.example.cinematicketproj.screens.SeatStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.DateFormatSymbols
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor() : ViewModel() {


    private val _pickerState = MutableStateFlow(listOf(DateUiState()))
    val pickerState = _pickerState.asStateFlow()
    var selectedItemIndex: Int = -1
        private set


    init {
        val dates = (1..31).toList()
        val dateUiStates = dates.map {
            DateUiState(
                date = it,
                day = getDayOfWeek(it)
            )
        }
        _pickerState.value = dateUiStates
    }


    private fun getDayOfWeek(day: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_MONTH, day)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return DateFormatSymbols().shortWeekdays[dayOfWeek]
    }

    fun onPickerItemClicked(selectedItem: Int) {
        val index = _pickerState.value.indexOfFirst { it.date == selectedItem }
        if (index >= 0) {
            val updatedList = _pickerState.value.toMutableList()
            if (selectedItemIndex >= 0 && selectedItemIndex != index) {
                val prevSelected = updatedList[selectedItemIndex].copy(isSelected = false)
                updatedList[selectedItemIndex] = prevSelected
            }
            val newSelected = updatedList[index].copy(isSelected = true)
            updatedList[index] = newSelected
            _pickerState.value = updatedList
            selectedItemIndex = index
        }
    }


    private val _state = MutableStateFlow(BookingUiState())
    val state = _state.asStateFlow()

    init {
        val columnLeft = listOf(
            Pair(
                BookingUiStateItem(1, SeatStatus.TAKEN),
                BookingUiStateItem(6, SeatStatus.SELECTED)
            ),
            Pair(
                BookingUiStateItem(2, SeatStatus.AVAILABLE),
                BookingUiStateItem(7, SeatStatus.SELECTED)
            ),
            Pair(
                BookingUiStateItem(3, SeatStatus.SELECTED),
                BookingUiStateItem(8, SeatStatus.AVAILABLE)
            ),
            Pair(
                BookingUiStateItem(4, SeatStatus.TAKEN),
                BookingUiStateItem(9, SeatStatus.AVAILABLE)
            ),
            Pair(
                BookingUiStateItem(5, SeatStatus.AVAILABLE),
                BookingUiStateItem(10, SeatStatus.TAKEN)
            )
        )
        val columnCenter = listOf(
            Pair(
                BookingUiStateItem(11, SeatStatus.TAKEN),
                BookingUiStateItem(16, SeatStatus.SELECTED)
            ),
            Pair(
                BookingUiStateItem(12, SeatStatus.AVAILABLE),
                BookingUiStateItem(17, SeatStatus.SELECTED)
            ),
            Pair(
                BookingUiStateItem(13, SeatStatus.SELECTED),
                BookingUiStateItem(18, SeatStatus.AVAILABLE)
            ),
            Pair(
                BookingUiStateItem(14, SeatStatus.TAKEN),
                BookingUiStateItem(19, SeatStatus.AVAILABLE)
            ),
            Pair(
                BookingUiStateItem(15, SeatStatus.AVAILABLE),
                BookingUiStateItem(20, SeatStatus.TAKEN)
            )
        )
        val columnRight = listOf(
            Pair(
                BookingUiStateItem(21, SeatStatus.TAKEN),
                BookingUiStateItem(22, SeatStatus.SELECTED)
            ),
            Pair(
                BookingUiStateItem(23, SeatStatus.AVAILABLE),
                BookingUiStateItem(24, SeatStatus.SELECTED)
            ),
            Pair(
                BookingUiStateItem(25, SeatStatus.SELECTED),
                BookingUiStateItem(26, SeatStatus.AVAILABLE)
            ),
            Pair(
                BookingUiStateItem(27, SeatStatus.TAKEN),
                BookingUiStateItem(28, SeatStatus.AVAILABLE)
            ),
            Pair(
                BookingUiStateItem(29, SeatStatus.AVAILABLE),
                BookingUiStateItem(30, SeatStatus.TAKEN)
            )
        )
        _state.update {
            it.copy(
                leftColumns = columnLeft,
                centerColumns = columnCenter,
                rightColumns = columnRight
            )
        }
    }

    fun onSeatClicked(bookingUiStateItem: BookingUiStateItem) {
        when (bookingUiStateItem.status) {
            SeatStatus.TAKEN -> return // Do nothing if the seat is already taken

            SeatStatus.SELECTED -> onSelectedSeatClicked(bookingUiStateItem)

            SeatStatus.AVAILABLE -> onAvailableSeatClicked(bookingUiStateItem)
        }
    }

    private fun onSelectedSeatClicked(bookingUiStateItem: BookingUiStateItem) {
        _state.update { currentState ->
            val updatedState = currentState.copy(
                leftColumns = updateColumn(
                    currentState.leftColumns, bookingUiStateItem.id,
                    SeatStatus.AVAILABLE
                ),
                centerColumns = updateColumn(
                    currentState.centerColumns, bookingUiStateItem.id,
                    SeatStatus.AVAILABLE
                ),
                rightColumns = updateColumn(
                    currentState.rightColumns, bookingUiStateItem.id,
                    SeatStatus.AVAILABLE
                )
            )
            updatedState
        }
    }

    private fun onAvailableSeatClicked(bookingUiStateItem: BookingUiStateItem) {
        _state.update { currentState ->
            val updatedState = currentState.copy(
                leftColumns = updateColumn(
                    currentState.leftColumns, bookingUiStateItem.id,
                    SeatStatus.SELECTED
                ),
                centerColumns = updateColumn(
                    currentState.centerColumns, bookingUiStateItem.id,
                    SeatStatus.SELECTED
                ),
                rightColumns = updateColumn(
                    currentState.rightColumns, bookingUiStateItem.id,
                    SeatStatus.SELECTED
                )
            )
            updatedState
        }
    }

    private fun updateColumn(
        column: List<Pair<BookingUiStateItem, BookingUiStateItem>>,
        id: Int,
        newStatus: SeatStatus
    ): List<Pair<BookingUiStateItem, BookingUiStateItem>> {
        return column.map { item ->
            when (id) {
                item.first.id -> item.copy(first = item.first.copy(status = newStatus))
                item.second.id -> item.copy(second = item.second.copy(status = newStatus))
                else -> item
            }
        }
    }
}



