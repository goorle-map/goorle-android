package dev.yjyoon.goorle.data.model

import com.google.gson.annotations.SerializedName

data class CommentResponse(
    @SerializedName("commentId")
    val id: String,
    val content: String,
    val writer: UserResponse,
    val createdAt: String
)
