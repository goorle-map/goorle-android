package dev.yjyoon.goorle.ui.map

import dev.yjyoon.goorle.ui.model.Post

data class MapState(
    val selectedPost: Post? = null,
    val posts: List<Post> = emptyList()
)
