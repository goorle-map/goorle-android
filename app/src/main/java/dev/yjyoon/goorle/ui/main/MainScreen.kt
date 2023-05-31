package dev.yjyoon.goorle.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.character.CharacterScreen
import dev.yjyoon.goorle.ui.home.HomeScreen
import dev.yjyoon.goorle.ui.mypage.MypageScreen
import dev.yjyoon.goorle.ui.post.CreateScreen
import dev.yjyoon.goorle.ui.post.GridViewType
import dev.yjyoon.goorle.ui.theme.GoorleBlue
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    navigateToGrid: (GridViewType) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )
    val navController = rememberAnimatedNavController()
    val navigation = rememberMainNavigation(navController)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetContent = {
            CreateScreen(dismiss = { coroutineScope.launch { modalSheetState.hide() } })
        }
    ) {
        Scaffold(
            topBar = {
                HomeTopBar(
                    onClickSearchBar = {}
                )
            },
            bottomBar = {
                MainNavigationBar(
                    currentDestination = currentDestination,
                    onNavigate = { navigation.navigateTo(it) },
                )
            },
            floatingActionButton = {
                if (MainDestination.Home in currentDestination) {
                    FloatingActionButton(
                        onClick = {
                            coroutineScope.launch {
                                modalSheetState.show()
                            }
                        },
                        containerColor = GoorleBlue,
                        contentColor = Color.White,
                        shape = CircleShape
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = null
                        )
                    }
                }

            }
        ) { padding ->
            AnimatedNavHost(
                navController = navigation.navController,
                startDestination = MainDestination.Home.route,
                modifier = Modifier.padding(padding)
            ) {
                composable(route = MainDestination.Home.route) {
                    HomeScreen(
                        navigateToGrid = navigateToGrid
                    )
                }
                composable(route = MainDestination.Character.route) {
                    CharacterScreen()
                }
                composable(route = MainDestination.MyPage.route) {
                    MypageScreen()
                }
            }
        }
    }
}

@Composable
private fun HomeTopBar(
    onClickSearchBar: () -> Unit
) {
    Surface(
        modifier = Modifier
            .height(HomeTopBarHeightExtended)
            .fillMaxWidth(),
        color = GoorleBlue,
        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.img_logo_white),
                contentDescription = null,
                modifier = Modifier.width(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable { onClickSearchBar() },
                color = Color.White,
                shape = RoundedCornerShape(24.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 12.dp, horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = GoorleBlue,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.home_search_bar_placeholder),
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF9E9E9E)
                    )
                }
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
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
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
private val HomeTopBarHeightExtended: Dp = 164.dp