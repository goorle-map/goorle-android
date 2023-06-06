package dev.yjyoon.goorle.data.model

import com.google.gson.annotations.SerializedName

data class PositionResponse(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lng: Double
)
