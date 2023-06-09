package dev.yjyoon.goorle.data.model

import com.google.gson.annotations.SerializedName
import dev.yjyoon.goorle.ui.model.Comment

data class CommentResponse(
    @SerializedName("commentId")
    val id: String,
    val content: String,
    val writer: UserResponse,
    val createdAt: String,
    val accommodation: PostResponse
)

fun CommentResponse.toModel() = Comment(
    nickname = writer.nickname,
    date = createdAt,
    content = content,
    image = accommodation?.images?.first() ?: "",
    title = accommodation?.name ?: "",
    location = accommodation?.location ?: ""
)
