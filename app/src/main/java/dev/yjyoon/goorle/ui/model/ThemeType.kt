package dev.yjyoon.goorle.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.yjyoon.goorle.R

enum class ThemeType(
    @StringRes val stringRes: Int,
    @DrawableRes val imageRes: Int
) {
    Nature(stringRes = R.string.theme_nature, imageRes = R.drawable.img_home_sec_01),
    Hanok(stringRes = R.string.theme_hanok, imageRes = R.drawable.img_home_sec_02),
    Dog(stringRes = R.string.theme_dog, imageRes = R.drawable.img_home_sec_03),
    Rural(stringRes = R.string.theme_rural, imageRes = R.drawable.img_home_sec_04),
    Ocean(stringRes = R.string.theme_ocean, imageRes = R.drawable.img_home_sec_05),
    Hotel(stringRes = R.string.theme_hotel, imageRes = R.drawable.img_home_sec_06),
    Tour(stringRes = R.string.theme_tour, imageRes = R.drawable.img_home_sec_07),
}
