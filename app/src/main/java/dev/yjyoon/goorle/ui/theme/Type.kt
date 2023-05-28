package dev.yjyoon.goorle.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.yjyoon.goorle.R

val NotoSansKr = FontFamily(
    Font(R.font.noto_sans_kr_regular, FontWeight.Normal),
    Font(R.font.noto_sans_kr_bold, FontWeight.Bold)
)

val Typography = Typography(
    headlineLarge = TextStyle(

        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Bold
    ),
    headlineMedium = TextStyle(

        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Bold
    ),
    headlineSmall = TextStyle(

        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Bold
    ),
    titleLarge = TextStyle(

        fontSize = 16.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Bold
    ),
    titleMedium = TextStyle(

        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Bold
    ),
    titleSmall = TextStyle(

        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Bold
    ),
    labelMedium = TextStyle(

        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Normal
    ),
    bodyLarge = TextStyle(

        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(

        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = TextStyle(

        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.6).sp,
        fontWeight = FontWeight.Normal
    ),
)

@Immutable
data class GoorleTypography(
    val headlineLarge: TextStyle,
    val headlineMedium: TextStyle,
    val headlineSmall: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val labelMedium: TextStyle,
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle
)

internal val LocalTypography = staticCompositionLocalOf { Typography }
