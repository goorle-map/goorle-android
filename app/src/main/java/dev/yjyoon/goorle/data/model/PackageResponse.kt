package dev.yjyoon.goorle.data.model

import com.google.gson.annotations.SerializedName
import dev.yjyoon.goorle.ui.model.Trip

data class PackageResponse(
    @SerializedName("packageId")
    val id: String,
    val name: String,
    val content: String,
    val imageUrl: String,
    val url: String
)

fun PackageResponse.toModel() = Trip(
    title = name,
    content = content,
    imageUrl = imageUrl,
    url = url
)
