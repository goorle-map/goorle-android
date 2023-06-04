package dev.yjyoon.goorle.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.yjyoon.goorle.R

enum class ThemeType(
    @StringRes val stringRes: Int,
    @StringRes val tagRes: Int,
    @DrawableRes val imageRes: Int,
) {
    Nature(
        stringRes = R.string.theme_nature,
        imageRes = R.drawable.img_home_sec_01,
        tagRes = R.string.tag_nature
    ),
    Hanok(
        stringRes = R.string.theme_hanok,
        imageRes = R.drawable.img_home_sec_02,
        tagRes = R.string.tag_hanok
    ),
    Dog(
        stringRes = R.string.theme_dog,
        imageRes = R.drawable.img_home_sec_03,
        tagRes = R.string.tag_dog
    ),
    Ocean(
        stringRes = R.string.theme_ocean,
        imageRes = R.drawable.img_home_sec_05,
        tagRes = R.string.tag_ocean
    ),
    Hotel(
        stringRes = R.string.theme_hotel,
        imageRes = R.drawable.img_home_sec_06,
        tagRes = R.string.tag_hotel
    ),
    Tour(
        stringRes = R.string.theme_tour,
        imageRes = R.drawable.img_home_sec_07,
        tagRes = R.string.tag_tour
    ),
}
