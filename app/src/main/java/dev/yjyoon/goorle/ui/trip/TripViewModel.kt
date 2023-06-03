package dev.yjyoon.goorle.ui.trip

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yjyoon.goorle.ui.model.Trip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TripViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(TripState())
    val uiState: StateFlow<TripState> = _uiState.asStateFlow()

    fun setTrip(trip: Trip?) {
        _uiState.update { it.copy(selectedTrip = trip) }
    }
}
