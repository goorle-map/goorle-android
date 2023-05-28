package dev.yjyoon.goorle.ui.list

import androidx.activity.compose.BackHandler
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.yjyoon.goorle.ui.component.GoorleTopBar

@Composable
fun GridScreen(
    onBack: () -> Unit,
    @StringRes titleRes: Int,
    content: LazyGridScope.() -> Unit
) {
    BackHandler {
        onBack()
    }

    Scaffold(
        topBar = {
            GoorleTopBar(titleRes = titleRes, onBack = onBack)
        }
    ) {
        LazyVerticalGrid(
            modifier = Modifier.padding(it),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = content
        )
    }
}