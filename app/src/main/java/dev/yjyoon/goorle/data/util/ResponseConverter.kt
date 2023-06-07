package dev.yjyoon.goorle.data.util

import dev.yjyoon.goorle.ui.model.FilterType
import dev.yjyoon.goorle.ui.model.ThemeType

object ResponseConverter {

    fun String.toFilterType() =
        FilterType.valueOf(capitalize())

    fun String.toThemeType() =
        ThemeType.valueOf(capitalize())

    private fun String.capitalize() =
        mapIndexed { idx, c ->
            if (idx > 0) c.lowercaseChar() else c.uppercaseChar()
        }.joinToString("")
}
