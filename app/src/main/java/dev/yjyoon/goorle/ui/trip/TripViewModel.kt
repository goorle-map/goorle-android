package dev.yjyoon.goorle.ui.trip

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.yjyoon.goorle.data.repository.ServiceRepository
import dev.yjyoon.goorle.ui.model.Trip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripViewModel @Inject constructor(
    private val serviceRepository: ServiceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TripState())
    val uiState: StateFlow<TripState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            serviceRepository.getAllPackages().onSuccess { trips ->
                _uiState.update { it.copy(trips = trips) }
            }
        }
    }
    
    fun setTrip(trip: Trip?) {
        _uiState.update { it.copy(selectedTrip = trip) }
    }
}
