package dev.yjyoon.goorle.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

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

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = GoorleWhite.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colorScheme = GoorleColorScheme,
        typography = Typography,
        content = content
    )
}
