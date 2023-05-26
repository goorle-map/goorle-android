package dev.yjyoon.goorle.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val GoorleColorScheme = lightColorScheme(
    primary = GoorleBlue,
    onPrimary = GoorleWhite,
    secondary = GoorleGreen,
    onSecondary = GoorleWhite,
    tertiary = GoorlePurple,
    onTertiary = GoorleWhite,
    background = GoorleWhite,
    onBackground = GoorleBlack,
    surface = GoorleWhite,
    onSurface = GoorleBlack,
    error = GoorleRed,
    onError = GoorleWhite
)

@Composable
fun GoorleTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = GoorleColorScheme,
        typography = Typography,
        content = content
    )
}
