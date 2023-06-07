package dev.yjyoon.goorle.ui.trip

import dev.yjyoon.goorle.ui.model.Trip

data class TripState(
    val selectedTrip: Trip? = null,
    val trips: List<Trip> = emptyList()
)
