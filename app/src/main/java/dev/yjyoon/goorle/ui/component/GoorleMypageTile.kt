package dev.yjyoon.goorle.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.model.Post

@Composable
fun GoorleMypageTile(
    modifier: Modifier = Modifier,
    post: Post,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.clickable { onClick() }
    ) {
        AsyncImage(
            model = post.images.first(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.then(
                Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(24.dp))
            )
        )
        Surface(
            modifier = modifier.then(
                Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(24.dp))
            ),
            color = Color.Black.copy(alpha = 0.5f)
        ) {}
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = post.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_location_on),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.height(12.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = post.location,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}