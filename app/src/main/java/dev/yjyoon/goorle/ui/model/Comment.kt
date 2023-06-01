package dev.yjyoon.goorle.ui.model

import java.io.Serializable

data class Comment(
    val nickname: String = "구르리",
    val date: String = "23.04.20",
    val content: String = "댓글을 이렇게 저렇게 달 수 있다.",
    val image: String = "https://avatars.githubusercontent.com/u/72238126?v=4",
    val title: String = "호텔 전주점",
    val location: String = "부산광역시 해운대구"
) : Serializable