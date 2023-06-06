package dev.yjyoon.goorle.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.model.Post
import dev.yjyoon.goorle.ui.theme.GoorleBlack
import dev.yjyoon.goorle.ui.theme.GoorleBlue
import dev.yjyoon.goorle.ui.theme.GoorleGray9E
import dev.yjyoon.goorle.ui.theme.GoorleGrayE0

@Composable
fun GoorleMapTile(
    modifier: Modifier = Modifier,
    post: Post,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier.then(
            Modifier
                .clip(RoundedCornerShape(24.dp))
                .clickable { onClick() }),
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(width = 1.dp, color = GoorleGrayE0),
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = post.images.first(),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(24.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = post.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = GoorleBlue
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = post.location,
                    style = MaterialTheme.typography.labelMedium,
                    color = GoorleGray9E
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    post.tags.take(2).forEach {
                        Text(
                            text = "#${stringResource(id = it.tagRes)} ",
                            style = MaterialTheme.typography.bodyMedium,
                            color = GoorleBlack
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                IconButton(onClick = onClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chevron_right),
                        contentDescription = null
                    )
                }
            }
        }
    }
}