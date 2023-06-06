package dev.yjyoon.goorle.data.model

import com.google.gson.annotations.SerializedName

data class PackageResponse(
    @SerializedName("packageId")
    val id: String,
)
