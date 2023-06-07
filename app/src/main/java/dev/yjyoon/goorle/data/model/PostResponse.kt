package dev.yjyoon.goorle.data.model

import com.google.gson.annotations.SerializedName
import dev.yjyoon.goorle.data.util.ResponseConverter.toFilterType
import dev.yjyoon.goorle.data.util.ResponseConverter.toThemeType
import dev.yjyoon.goorle.ui.model.Post

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

fun PostResponse.toModel() = Post(
    id = id,
    images = images,
    title = name,
    location = location,
    filters = features.map { it.toFilterType() },
    tags = tags.map { it.toThemeType() },
    comments = comments.map { it.toModel() },
    lng = position.lng,
    lat = position.lat
)
