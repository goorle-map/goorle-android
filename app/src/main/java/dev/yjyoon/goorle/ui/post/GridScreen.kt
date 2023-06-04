package dev.yjyoon.goorle.ui.post

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.yjyoon.goorle.ui.component.GoorleDivider
import dev.yjyoon.goorle.ui.component.GoorleFilterChip
import dev.yjyoon.goorle.ui.component.GoorlePostItem
import dev.yjyoon.goorle.ui.component.GoorleSectionTileASmall
import dev.yjyoon.goorle.ui.component.GoorleSectionTileB
import dev.yjyoon.goorle.ui.component.GoorleTopBar
import dev.yjyoon.goorle.ui.model.FilterType
import dev.yjyoon.goorle.ui.model.Post
import dev.yjyoon.goorle.ui.model.RegionType
import dev.yjyoon.goorle.ui.model.ThemeType

@Composable
fun GridScreen(
    viewModel: GridViewModel,
    type: GridViewType,
    onBack: () -> Unit,
    navigateToDetail: (Post) -> Unit,
    navigateToMap: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    BackHandler {
        onBack()
    }

    Scaffold(
        topBar = {
            Column {
                GoorleTopBar(
                    titleRes = uiState.titleRes,
                    onBack = onBack
                )
                uiState.posts?.let {
                    GoorleDivider()
                    Surface(
                        modifier = Modifier
                            .height(64.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                        color = Color.White
                    ) {
                        LazyRow(
                            contentPadding = PaddingValues(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            items(FilterType.values()) {
                                GoorleFilterChip(
                                    selected = it in uiState.filters,
                                    filterType = it,
                                    onClick = viewModel::modifyFilter
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        uiState.posts?.let {
            LazyColumn(
                modifier = Modifier.padding(innerPadding),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(it) { post ->
                    if (uiState.filters.isEmpty() || post.filters.containsAll(uiState.filters)) {
                        GoorlePostItem(post = post, onClick = { navigateToDetail(post) })
                    }
                }
            }
        } ?: LazyVerticalGrid(
            modifier = Modifier.padding(innerPadding),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 24.dp, horizontal = 16.dp)
        ) {
            when (type) {
                GridViewType.Theme -> {
                    items(ThemeType.values()) {
                        GoorleSectionTileASmall(
                            imageRes = it.imageRes,
                            textRes = it.stringRes,
                            onClick = {
                                viewModel.loadThemeList(it)
                            }
                        )
                    }
                }
                GridViewType.Region -> {
                    items(RegionType.values()) {
                        GoorleSectionTileB(
                            imageRes = it.imageRes,
                            textRes = it.stringRes,
                            onClick = { navigateToMap() }
                        )
                    }
                }
            }
        }
    }
}
