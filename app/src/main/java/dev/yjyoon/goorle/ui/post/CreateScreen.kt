package dev.yjyoon.goorle.ui.post

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.component.GoorleImagePicker
import dev.yjyoon.goorle.ui.component.GoorleThemeChip
import dev.yjyoon.goorle.ui.model.FilterType
import dev.yjyoon.goorle.ui.model.ThemeType
import dev.yjyoon.goorle.ui.theme.GoorleBlue
import dev.yjyoon.goorle.ui.theme.GoorleGray75
import dev.yjyoon.goorle.ui.theme.GoorleGrayBD
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreateScreen(
    viewModel: CreateViewModel = hiltViewModel(),
    dismiss: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    BackHandler { dismiss() }

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(vertical = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.new_post_title),
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )
            CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                IconButton(onClick = dismiss) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_clear),
                        contentDescription = null
                    )
                }
            }
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.new_post_search),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.height(16.dp))
        BasicTextField(
            modifier = Modifier.height(36.dp),
            value = uiState.title,
            textStyle = MaterialTheme.typography.bodyMedium,
            onValueChange = { viewModel.inputTitle(it) },
            singleLine = true,
            decorationBox = { innerTextField ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    color = Color.White,
                    border = BorderStroke(width = 1.dp, color = GoorleGrayBD)
                ) {
                    Row(
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            if (uiState.title.isEmpty()) {
                                Text(
                                    stringResource(id = R.string.new_post_search_placeholder),
                                    color = GoorleGray75,
                                    style = MaterialTheme.typography.labelMedium,
                                    maxLines = 1
                                )
                            }
                            innerTextField()
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = null,
                                tint = GoorleGray75
                            )
                        }
                    }
                }
            }
        )
        Text(
            text = stringResource(id = R.string.new_post_image, uiState.images.size),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        GoorleImagePicker(
            images = uiState.images,
            onPickImage = viewModel::onPickImage,
            onDeleteImage = viewModel::deleteImage
        )
        Text(
            text = stringResource(id = R.string.new_post_tag),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ThemeType.values().take(4).forEach {
                GoorleThemeChip(
                    selected = it in uiState.tags,
                    themeType = it,
                    onClick = viewModel::modifyTag
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ThemeType.values().takeLast(3).forEach {
                GoorleThemeChip(
                    selected = it in uiState.tags,
                    themeType = it,
                    onClick = viewModel::modifyTag
                )
            }
        }
        Text(
            text = stringResource(id = R.string.new_post_filter),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilterType.values().take(4).forEach {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { viewModel.modifyFilter(it) }
                ) {
                    Box(
                        modifier = Modifier.size(48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = it.iconRes),
                            contentDescription = null,
                            tint = if (it in uiState.filters) GoorleBlue else GoorleGray75,
                            modifier = Modifier
                                .size(42.dp)
                                .align(Alignment.Center)
                        )
                        if (it in uiState.filters) {
                            Surface(
                                shape = CircleShape,
                                color = GoorleBlue.copy(alpha = 0.1f),
                                modifier = Modifier
                                    .size(48.dp)
                                    .align(Alignment.Center)
                            ) {

                            }
                            Image(
                                painter = painterResource(id = R.drawable.ic_filter_check),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(16.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = stringResource(id = it.stringRes),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium,
                        color = if (it in uiState.filters) GoorleBlue else GoorleGray75
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FilterType.values().takeLast(4).forEach {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clickable { viewModel.modifyFilter(it) }
                ) {
                    Box(
                        modifier = Modifier.size(48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = it.iconRes),
                            contentDescription = null,
                            tint = if (it in uiState.filters) GoorleBlue else GoorleGray75,
                            modifier = Modifier
                                .size(42.dp)
                                .align(Alignment.Center)
                        )
                        if (it in uiState.filters) {
                            Surface(
                                shape = CircleShape,
                                color = GoorleBlue.copy(alpha = 0.1f),
                                modifier = Modifier
                                    .size(48.dp)
                                    .align(Alignment.Center)
                            ) {

                            }
                            Image(
                                painter = painterResource(id = R.drawable.ic_filter_check),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(16.dp)
                                    .align(Alignment.TopEnd)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = stringResource(id = it.stringRes),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.labelMedium,
                        color = if (it in uiState.filters) GoorleBlue else GoorleGray75
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                coroutineScope.launch {
                    delay(1000L)
                    Toast.makeText(context, "숙소 등록이 완료되었습니다", Toast.LENGTH_SHORT).show()
                    dismiss()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.new_post_add),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}