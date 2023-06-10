package dev.yjyoon.goorle.ui.map

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.MarkerState
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.component.GoorleMapTile
import dev.yjyoon.goorle.ui.component.GoorleTopBar
import dev.yjyoon.goorle.ui.model.Post
import dev.yjyoon.goorle.ui.model.Seoul
import dev.yjyoon.goorle.ui.theme.GoorleGray75
import dev.yjyoon.goorle.ui.theme.GoorleGrayBD
import kotlinx.coroutines.launch

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MapScreen(
    viewModel: MapViewModel,
    onClose: () -> Unit,
    navigateToDetail: (Post) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition(Seoul.Jongro.latlng, ZOOM_LEVEL)
    }

    Scaffold(
        topBar = {
            GoorleTopBar(
                titleRes = R.string.seoul_goorle_map,
                onBack = onClose
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            NaverMap(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                cameraPositionState = cameraPositionState
            ) {
                uiState.posts.forEach { post ->
                    Marker(
                        state = MarkerState(position = LatLng(post.lat, post.lng)),
                        captionText = post.title,
                        onClick = {
                            viewModel.selectPost(post)
                            true
                        }
                    )
                }
            }
            LazyColumn(
                modifier = Modifier.align(Alignment.CenterStart),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(Seoul.values()) {
                    Surface(
                        shape = RoundedCornerShape(50.dp),
                        border = BorderStroke(1.dp, color = GoorleGrayBD),
                        color = Color.White,
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .clickable {
                                coroutineScope.launch {
                                    cameraPositionState.animate(
                                        update = CameraUpdate.toCameraPosition(
                                            CameraPosition(
                                                it.latlng,
                                                ZOOM_LEVEL
                                            )
                                        ),
                                        animation = CameraAnimation.Easing,
                                        durationMs = 1000
                                    )
                                }
                            }
                    ) {
                        Text(
                            text = stringResource(id = it.stringRes),
                            style = MaterialTheme.typography.labelMedium,
                            color = GoorleGray75,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
            uiState.selectedPost?.let {
                GoorleMapTile(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 40.dp)
                        .align(Alignment.BottomCenter),
                    post = it,
                    onClick = { navigateToDetail(it) }
                )
            }
        }
    }
}

private val ZOOM_LEVEL: Double = 13.0
