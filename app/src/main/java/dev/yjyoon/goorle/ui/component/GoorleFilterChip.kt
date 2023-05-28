package dev.yjyoon.goorle.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.yjyoon.goorle.ui.model.FilterType
import dev.yjyoon.goorle.ui.theme.GoorleBlue
import dev.yjyoon.goorle.ui.theme.GoorleGray75

@Composable
fun GoorleFilterChip(
    selected: Boolean,
    filterType: FilterType,
    onClick: (FilterType) -> Unit
) {
    FilterChip(
        selected = selected,
        onClick = { onClick(filterType) },
        label = {
            Text(
                text = stringResource(id = filterType.stringRes),
                style = MaterialTheme.typography.labelMedium
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = filterType.iconRes),
                contentDescription = null
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Color.White,
            labelColor = GoorleGray75,
            selectedLabelColor = GoorleBlue,
            selectedContainerColor = Color.White,
            iconColor = GoorleGray75,
            selectedLeadingIconColor = GoorleBlue
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = GoorleGray75,
            selectedBorderColor = GoorleBlue,
            borderWidth = 1.dp,
            selectedBorderWidth = 1.dp
        ),
        shape = RoundedCornerShape(50.dp)
    )
}
