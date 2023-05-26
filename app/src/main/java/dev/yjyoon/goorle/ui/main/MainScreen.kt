package dev.yjyoon.goorle.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dev.yjyoon.goorle.ui.character.CharacterScreen
import dev.yjyoon.goorle.ui.home.HomeScreen
import dev.yjyoon.goorle.ui.mypage.MypageScreen
import dev.yjyoon.goorle.ui.theme.GoorleBlue

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val navController = rememberAnimatedNavController()
    val navigation = rememberMainNavigation(navController)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        topBar = {

        },
        modifier = Modifier,
        bottomBar = {
            MainNavigationBar(
                currentDestination = currentDestination,
                onNavigate = { navigation.navigateTo(it) },
            )
        },
    ) { padding ->
        AnimatedNavHost(
            navController = navigation.navController,
            startDestination = MainDestination.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(route = MainDestination.Home.route) {
                HomeScreen()
            }
            composable(route = MainDestination.Character.route) {
                CharacterScreen()
            }
            composable(MainDestination.MyPage.route) {
                MypageScreen()
            }
        }
    }
}

@Composable
private fun MainNavigationBar(
    currentDestination: NavDestination?,
    onNavigate: (MainDestination) -> Unit,
) {
    Surface(
        shadowElevation = 40.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(NavigationBarHeight),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MainDestination.values().forEach { destination ->
                val selected = destination in currentDestination

                NavigationBarItem(
                    selected = selected,
                    destination = destination,
                    onClick = { onNavigate(destination) }
                )
            }
        }
    }
}

private operator fun NavDestination?.contains(destination: MainDestination): Boolean {
    if (this == null) {
        return false
    }
    return hierarchy.any { it.route == destination.route }
}

@Composable
private fun NavigationBarItem(
    selected: Boolean,
    destination: MainDestination,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .selectable(
                selected = selected,
                onClick = onClick,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .width(32.dp)
                .height(2.dp),
            color = if (selected) GoorleBlue else Color.White
        ) {}
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = destination.icon(selected)),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = destination.text(),
                textAlign = TextAlign.Center,
                color = destination.color(selected),
                fontSize = 10.sp
            )
        }
    }
}

private val NavigationBarHeight: Dp = 58.dp