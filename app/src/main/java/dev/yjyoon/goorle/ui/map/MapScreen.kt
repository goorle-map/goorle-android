package dev.yjyoon.goorle.ui.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.NaverMap
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.component.GoorleTopBar

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MapScreen(
    onClose: () -> Unit
) {
    Scaffold(
        topBar = {
            GoorleTopBar(
                titleRes = R.string.seoul_goorle_map,
                onBack = onClose
            )
        }
    ) { innerPadding ->
        NaverMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }
}
