package dev.yjyoon.goorle.ui.mypage

import dev.yjyoon.goorle.ui.model.Comment
import dev.yjyoon.goorle.ui.model.Post

data class MypageState(
    val nickname: String = "여섯자닉네임",
    val posts: List<Post> = List(20) { Post() },
    val comments: List<Comment> = List(5) { Comment() }
)
