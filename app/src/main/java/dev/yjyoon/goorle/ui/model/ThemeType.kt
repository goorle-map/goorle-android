package dev.yjyoon.goorle.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.yjyoon.goorle.R

enum class ThemeType(
    @StringRes stringRes: Int,
    @DrawableRes imageRes: Int
) {
    Nature(stringRes = R.string.home_section_item_01, imageRes = R.drawable.img_home_sec_01),
    Hanok(stringRes = R.string.home_section_item_02, imageRes = R.drawable.img_home_sec_02),
    Dog(stringRes = R.string.home_section_item_03, imageRes = R.drawable.img_home_sec_03),
    Rural(stringRes = R.string.home_section_item_04, imageRes = R.drawable.img_home_sec_04),
    Ocean(stringRes = R.string.home_section_item_05, imageRes = R.drawable.img_home_sec_05),
    Hotel(stringRes = R.string.home_section_item_06, imageRes = R.drawable.img_home_sec_06),
    Tour(stringRes = R.string.home_section_item_07, imageRes = R.drawable.img_home_sec_07),
}
