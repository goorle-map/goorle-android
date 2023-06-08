package dev.yjyoon.goorle.ui.component

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.model.Comment
import dev.yjyoon.goorle.ui.theme.GoorleGray75
import dev.yjyoon.goorle.ui.theme.GoorleGray9E
import dev.yjyoon.goorle.ui.theme.GoorleGrayE0

@Composable
fun GoorleCommentTile(
    comment: Comment
) {
    Surface(
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(width = 1.dp, color = GoorleGrayE0)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    AsyncImage(
                        model = comment.image,
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = comment.title,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_location_on),
                                contentDescription = null,
                                tint = GoorleGray9E,
                                modifier = Modifier.height(12.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = comment.location,
                                style = MaterialTheme.typography.titleSmall,
                                color = GoorleGray9E
                            )
                        }
                    }
                }
                Text(
                    text = comment.date.take(10),
                    style = MaterialTheme.typography.titleSmall,
                    color = GoorleGray75
                )
            }
            GoorleDivider(modifier = Modifier.padding(vertical = 8.dp))
            Text(
                text = comment.content,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
