package dev.yjyoon.goorle.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.component.GoorleSection
import dev.yjyoon.goorle.ui.component.GoorleSectionTileA
import dev.yjyoon.goorle.ui.component.GoorleSectionTileB
import dev.yjyoon.goorle.ui.component.GoorleSectionTileC
import dev.yjyoon.goorle.ui.component.GoorleSectionTileD
import dev.yjyoon.goorle.ui.model.RegionType
import dev.yjyoon.goorle.ui.model.ThemeType
import dev.yjyoon.goorle.ui.post.GridViewType
import dev.yjyoon.goorle.ui.theme.GoorleBlack

@Composable
fun HomeScreen(
    navigateToGrid: (GridViewType) -> Unit
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.fillMaxSize()
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
                subtitleRes = R.string.home_section_subtitle_03,
                onTap = { }
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                GoorleSectionTileC(
                    color = Color(0xFFADDEFF),
                    onClick = {}
                )
                GoorleSectionTileC(
                    color = Color(0xFFC2FFAD),
                    onClick = {}
                )
                GoorleSectionTileC(
                    color = Color(0xFFC9ADFF),
                    onClick = {}
                )
                GoorleSectionTileC(
                    color = Color(0xFFFFCEAD),
                    onClick = {}
                )
                GoorleSectionTileC(
                    color = Color(0xFFADDEFF),
                    onClick = {}
                )
                GoorleSectionTileC(
                    color = Color(0xFFC2FFAD),
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Spacer(modifier = Modifier.height(18.dp))
            GoorleSection(
                titleRes = R.string.home_section_title_04,
                subtitleRes = R.string.home_section_subtitle_04,
                onTap = { /*TODO*/ }
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                GoorleSectionTileD(
                    imageRes = R.drawable.img_comment_tile,
                    onClick = {}
                )
                GoorleSectionTileD(
                    imageRes = R.drawable.img_comment_tile,
                    onClick = {}
                )
                GoorleSectionTileD(
                    imageRes = R.drawable.img_comment_tile,
                    onClick = {}
                )
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
                    modifier = Modifier.padding(vertical = 8.dp),
                    titleRes = R.string.home_section_title_05,
                    subtitleRes = R.string.home_section_subtitle_05,
                    textColor = GoorleBlack,
                    onTap = { /*TODO*/ }
                ) {}
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}