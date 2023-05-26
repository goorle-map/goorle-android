package dev.yjyoon.goorle.ui.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun GoorleSectionTileA(
    @DrawableRes imageRes: Int,
    @StringRes textRes: Int,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.clickable { onClick() }) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(224.dp)
                .aspectRatio(3 / 4f)
                .clip(RoundedCornerShape(24.dp))
        )
        Text(
            text = stringResource(id = textRes),
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 24.dp)
                .align(Alignment.BottomStart)
        )
    }
}
