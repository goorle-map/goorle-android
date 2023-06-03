package dev.yjyoon.goorle.ui.trip

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.component.GoorleTopBar
import dev.yjyoon.goorle.ui.component.GoorleTripTile
import dev.yjyoon.goorle.ui.theme.GoorleGray75

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun TripScreen(
    viewModel: TripViewModel,
    onClose: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val webViewState = rememberWebViewState(uiState.selectedTrip?.url ?: "")

    Scaffold(
        topBar = {
            GoorleTopBar(
                titleRes = R.string.package_trip,
                onBack = { if (uiState.selectedTrip == null) onClose() else viewModel.setTrip(null) }
            )
        }
    ) { innerPadding ->
        uiState.selectedTrip?.let {
            WebView(
                state = webViewState,
                onCreated = { it.settings.javaScriptEnabled = true }
            )
        } ?: LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { HelpTile() }
            items(uiState.trips) {
                GoorleTripTile(
                    trip = it,
                    onClick = { viewModel.setTrip(it) }
                )
            }
        }
    }
}

@Composable
fun HelpTile() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_info),
            contentDescription = null,
            tint = Color(0xFFFFA24C),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = stringResource(id = R.string.package_trip_content),
            style = MaterialTheme.typography.titleMedium,
            color = GoorleGray75,
            textAlign = TextAlign.Center
        )
    }
}