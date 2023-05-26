package dev.yjyoon.goorle.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainNavigation(
    val navController: NavHostController
) {

    fun navigateTo(destination: MainDestination) {

        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun rememberMainNavigation(
    navController: NavHostController = rememberAnimatedNavController()
) = remember(navController) {
    MainNavigation(
        navController = navController
    )
}
