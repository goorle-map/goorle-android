package dev.yjyoon.goorle.ui.mypage

import androidx.annotation.StringRes
import dev.yjyoon.goorle.R

enum class MypageTab(
    @StringRes val textRes: Int
) {
    Place(R.string.tab_place),
    Comment(R.string.tab_comment)
}
