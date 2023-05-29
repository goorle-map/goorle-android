package dev.yjyoon.goorle.ui.post

import androidx.annotation.StringRes
import dev.yjyoon.goorle.ui.model.FilterType
import dev.yjyoon.goorle.ui.model.Post

data class GridState(
    @StringRes val titleRes: Int,
    val posts: List<Post>? = null,
    val filters: List<FilterType> = emptyList()
)
