package dev.yjyoon.goorle.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.theme.GoorleBlack

private const val NO_ROUTE = "no_route"
private const val ROUTE_HOME = "home"
private const val ROUTE_CHARACTER = "character"
private const val ROUTE_MYPAGE = "mypage"

enum class MainDestination(
    val route: String,
    private val activeIconResId: Int,
    private val inactiveIconResId: Int,
    private val iconTextResId: Int,
) {
    Character(
        route = ROUTE_CHARACTER,
        activeIconResId = R.drawable.ic_character,
        inactiveIconResId = R.drawable.ic_character_gray,
        iconTextResId = R.string.character,
    ),
    Home(
        route = ROUTE_HOME,
        activeIconResId = R.drawable.ic_home,
        inactiveIconResId = R.drawable.ic_home_gray,
        iconTextResId = R.string.home,
    ),
    MyPage(
        route = ROUTE_MYPAGE,
        activeIconResId = R.drawable.ic_mypage,
        inactiveIconResId = R.drawable.ic_mypage_gray,
        iconTextResId = R.string.mypage,
    );

    @Composable
    fun text() = stringResource(id = iconTextResId)

    @Composable
    fun color(selected: Boolean) = if (selected) {
        GoorleBlack
    } else {
        Color(0xFFBDBDBD)
    }

    fun icon(selected: Boolean) = if (selected) activeIconResId else inactiveIconResId
}
