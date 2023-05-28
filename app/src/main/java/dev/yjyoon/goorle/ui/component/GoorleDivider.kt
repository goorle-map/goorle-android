package dev.yjyoon.goorle.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.yjyoon.goorle.ui.theme.GoorleGrayE0

@Composable
fun GoorleDivider(
    modifier: Modifier = Modifier
) {
    Divider(
        modifier = modifier.then(Modifier.fillMaxWidth()),
        thickness = (0.75).dp,
        color = GoorleGrayE0
    )
}
