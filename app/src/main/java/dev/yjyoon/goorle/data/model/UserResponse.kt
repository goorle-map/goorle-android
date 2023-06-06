package dev.yjyoon.goorle.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("userId")
    val id: String,
    val nickname: String,
    val score: Int,
    val level: Int
)