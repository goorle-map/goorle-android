package dev.yjyoon.goorle.data.model

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("accommodationId")
    val id: String,
    val name: String,
    val location: String,
    val position: PositionResponse,
    val images: List<String>,
    val tags: List<String>,
    val features: List<String>,
    val comments: List<CommentResponse>
)
