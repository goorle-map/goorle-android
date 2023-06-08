package dev.yjyoon.goorle.ui.home

import dev.yjyoon.goorle.ui.model.Comment

data class HomeState(
    val recentComments: List<Comment> = emptyList()
)
