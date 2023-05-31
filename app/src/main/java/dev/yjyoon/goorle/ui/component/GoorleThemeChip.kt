package dev.yjyoon.goorle.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.yjyoon.goorle.ui.model.ThemeType
import dev.yjyoon.goorle.ui.theme.GoorleBlue
import dev.yjyoon.goorle.ui.theme.GoorleGray75
import dev.yjyoon.goorle.ui.theme.GoorleGrayBD

@Composable
fun GoorleThemeChip(
    selected: Boolean,
    themeType: ThemeType,
    onClick: (ThemeType) -> Unit
) {
    FilterChip(
        selected = selected,
        onClick = { onClick(themeType) },
        label = {
            Text(
                text = stringResource(id = themeType.tagRes),
                style = MaterialTheme.typography.labelMedium
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            labelColor = GoorleGray75,
            selectedLabelColor = GoorleBlue,
            selectedContainerColor = Color.White,
            iconColor = GoorleGrayBD,
            selectedLeadingIconColor = GoorleBlue
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = GoorleGrayBD,
            selectedBorderColor = GoorleBlue,
            borderWidth = 1.dp,
            selectedBorderWidth = 1.dp
        ),
        shape = RoundedCornerShape(50.dp)
    )
}
