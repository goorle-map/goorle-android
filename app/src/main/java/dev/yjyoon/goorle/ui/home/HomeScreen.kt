package dev.yjyoon.goorle.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import dev.yjyoon.goorle.ui.theme.GoorleBlack

@Composable
fun HomeScreen() {
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
                onTap = { /*TODO*/ }
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                GoorleSectionTileA(
                    imageRes = R.drawable.img_home_sec_01,
                    textRes = R.string.home_section_item_01,
                    onClick = { }
                )
                GoorleSectionTileA(
                    imageRes = R.drawable.img_home_sec_02,
                    textRes = R.string.home_section_item_02,
                    onClick = { }
                )
                GoorleSectionTileA(
                    imageRes = R.drawable.img_home_sec_03,
                    textRes = R.string.home_section_item_03,
                    onClick = { }
                )
                GoorleSectionTileA(
                    imageRes = R.drawable.img_home_sec_04,
                    textRes = R.string.home_section_item_04,
                    onClick = { }
                )
                GoorleSectionTileA(
                    imageRes = R.drawable.img_home_sec_05,
                    textRes = R.string.home_section_item_05,
                    onClick = { }
                )
                GoorleSectionTileA(
                    imageRes = R.drawable.img_home_sec_06,
                    textRes = R.string.home_section_item_06,
                    onClick = { }
                )
                GoorleSectionTileA(
                    imageRes = R.drawable.img_home_sec_07,
                    textRes = R.string.home_section_item_07,
                    onClick = { }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Spacer(modifier = Modifier.height(18.dp))
            GoorleSection(
                titleRes = R.string.home_section_title_02,
                subtitleRes = R.string.home_section_subtitle_02,
                onTap = { /*TODO*/ }
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                GoorleSectionTileB(
                    imageRes = R.drawable.img_seoul,
                    textRes = R.string.seoul,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_busan,
                    textRes = R.string.busan,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_daegu,
                    textRes = R.string.daegu,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_incheon,
                    textRes = R.string.incheon,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_gwangju,
                    textRes = R.string.gwangju,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_daejeon,
                    textRes = R.string.daejeon,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_ulsan,
                    textRes = R.string.ulsan,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_sejong,
                    textRes = R.string.sejong,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_gyeonggi,
                    textRes = R.string.gyeongi,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_gangwon,
                    textRes = R.string.gangwon,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_chungbuk,
                    textRes = R.string.chungbook,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_chungnam,
                    textRes = R.string.chungnam,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_jeonbuk,
                    textRes = R.string.geonbook,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_jeonnam,
                    textRes = R.string.geonnam,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_gyeongbuk,
                    textRes = R.string.kyoungbook,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_gyeongnam,
                    textRes = R.string.kyoungnam,
                    onClick = {}
                )
                GoorleSectionTileB(
                    imageRes = R.drawable.img_jeju,
                    textRes = R.string.jeju,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Spacer(modifier = Modifier.height(18.dp))
            GoorleSection(
                titleRes = R.string.home_section_title_03,
                subtitleRes = R.string.home_section_subtitle_03,
                onTap = { /*TODO*/ }
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