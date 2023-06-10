package dev.yjyoon.goorle.ui.mypage

import dev.yjyoon.goorle.ui.model.Comment
import dev.yjyoon.goorle.ui.model.Post

data class MypageState(
    val nickname: String = "떠돌이휴가중",
    val posts: List<Post> = emptyList(),
    val comments: List<Comment> = emptyList()
)
