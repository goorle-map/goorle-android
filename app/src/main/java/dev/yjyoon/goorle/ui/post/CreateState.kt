package dev.yjyoon.goorle.ui.post

import android.graphics.Bitmap
import dev.yjyoon.goorle.ui.model.FilterType
import dev.yjyoon.goorle.ui.model.ThemeType

data class CreateState(
    val title: String = "",
    val location: String = "",
    val images: List<Bitmap> = emptyList(),
    val tags: List<ThemeType> = emptyList(),
    val filters: List<FilterType> = emptyList(),
    val isValid: Boolean = title.isNotBlank()
            && images.isNotEmpty()
            && tags.isNotEmpty()
            && filters.isNotEmpty()
)
