package dev.yjyoon.goorle.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.yjyoon.goorle.R
import dev.yjyoon.goorle.ui.model.Comment
import dev.yjyoon.goorle.ui.theme.GoorleGray9E

@Composable
fun GoorleComment(
    modifier: Modifier = Modifier,
    comment: Comment
) {
    Row(
        modifier = modifier.then(Modifier.fillMaxWidth()),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_character_0),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = comment.nickname, style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = comment.date,
                    style = MaterialTheme.typography.labelMedium,
                    color = GoorleGray9E
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = comment.content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}