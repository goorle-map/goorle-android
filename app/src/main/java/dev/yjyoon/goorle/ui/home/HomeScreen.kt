package dev.yjyoon.goorle.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.component.GoorleSection
import dev.yjyoon.goorle.ui.component.GoorleSectionTileA
import dev.yjyoon.goorle.ui.component.GoorleSectionTileB
import dev.yjyoon.goorle.ui.component.GoorleSectionTileC
import dev.yjyoon.goorle.ui.component.GoorleSectionTileD
import dev.yjyoon.goorle.ui.model.Post
import dev.yjyoon.goorle.ui.model.RegionType
import dev.yjyoon.goorle.ui.model.ThemeType
import dev.yjyoon.goorle.ui.post.GridViewType
import dev.yjyoon.goorle.ui.theme.GoorleBlack
import dev.yjyoon.goorle.ui.theme.GoorleBlue

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToGrid: (GridViewType) -> Unit,
    navigateToTrip: () -> Unit,
    navigateToDetail: (Post) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            HomeTopBar(
                onClickSearchBar = {}
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                GoorleSection(
                    titleRes = R.string.home_section_title_01,
                    subtitleRes = R.string.home_section_subtitle_01,
                    onTap = { navigateToGrid(GridViewType.Theme) }
                ) {
                    Spacer(modifier = Modifier.width(8.dp))
                    ThemeType.values().forEach {
                        GoorleSectionTileA(
                            imageRes = it.imageRes,
                            textRes = it.stringRes,
                            onClick = { }
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Spacer(modifier = Modifier.height(18.dp))
                GoorleSection(
                    titleRes = R.string.home_section_title_02,
                    subtitleRes = R.string.home_section_subtitle_02,
                    onTap = { navigateToGrid(GridViewType.Region) }
                ) {
                    Spacer(modifier = Modifier.width(8.dp))
                    RegionType.values().forEach {
                        GoorleSectionTileB(
                            modifier = Modifier.size(156.dp),
                            imageRes = it.imageRes,
                            textRes = it.stringRes,
                            onClick = {}
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Spacer(modifier = Modifier.height(18.dp))
                GoorleSection(
                    titleRes = R.string.home_section_title_03,
                    subtitleRes = R.string.home_section_subtitle_03
                ) {
                    Spacer(modifier = Modifier.width(8.dp))
                    GoorleSectionTileC(
                        color = Color(0xFFADDEFF),
                        onClick = {},
                        pickCount = 20
                    )
                    GoorleSectionTileC(
                        color = Color(0xFFC2FFAD),
                        onClick = {},
                        pickCount = 17
                    )
                    GoorleSectionTileC(
                        color = Color(0xFFC9ADFF),
                        onClick = {},
                        pickCount = 16
                    )
                    GoorleSectionTileC(
                        color = Color(0xFFFFCEAD),
                        onClick = {},
                        pickCount = 14
                    )
                    GoorleSectionTileC(
                        color = Color(0xFFADDEFF),
                        onClick = {},
                        pickCount = 11
                    )
                    GoorleSectionTileC(
                        color = Color(0xFFC2FFAD),
                        onClick = {},
                        pickCount = 5
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Spacer(modifier = Modifier.height(18.dp))
                GoorleSection(
                    titleRes = R.string.home_section_title_04,
                    subtitleRes = R.string.home_section_subtitle_04
                ) {
                    Spacer(modifier = Modifier.width(8.dp))
                    uiState.recentComments.forEach {
                        GoorleSectionTileD(
                            imageUrl = it.image,
                            text = it.content,
                            subText = it.nickname,
                            onClick = {
                                navigateToDetail(
                                    Post(
                                        images = listOf(it.image),
                                        title = it.title,
                                        location = it.location,
                                        comments = listOf(it),
                                        lng = 126.3786906,
                                        lat = 33.47604254,
                                    )
                                )
                            },
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(24.dp),
                    color = Color(0xFF9CFF7A)
                ) {
                    GoorleSection(
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .clickable { navigateToTrip() },
                        titleRes = R.string.home_section_title_05,
                        subtitleRes = R.string.home_section_subtitle_05,
                        textColor = GoorleBlack,
                        onTap = { }
                    ) {}
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun HomeTopBar(
    onClickSearchBar: () -> Unit
) {
    var keyword by remember { mutableStateOf("") }

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
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = keyword,
                textStyle = MaterialTheme.typography.titleLarge.copy(color = Color(0xFF9E9E9E)),
                onValueChange = { keyword = it },
                singleLine = true,
                decorationBox = { innerTextField ->
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
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
                            Box(modifier = Modifier.weight(1f)) {
                                if (keyword.isEmpty()) {
                                    Text(
                                        text = stringResource(id = R.string.home_search_bar_placeholder),
                                        style = MaterialTheme.typography.titleLarge,
                                        color = Color(0xFF9E9E9E)
                                    )
                                }
                                innerTextField()
                            }
                        }
                    }
                }
            )
        }
    }
}

private val HomeTopBarHeightExtended: Dp = 164.dp
