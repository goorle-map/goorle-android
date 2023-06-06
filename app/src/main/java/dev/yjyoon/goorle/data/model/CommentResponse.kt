package dev.yjyoon.goorle.data.model

import com.google.gson.annotations.SerializedName

data class CommentResponse(
    @SerializedName("commendId")
    val id: String,
    val content: String,
    val writer: UserResponse,
    val createdAt: String
)
