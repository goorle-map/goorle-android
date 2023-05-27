package dev.yjyoon.goorle.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import dev.yjyoon.goorle.R

enum class FilterType(
    @StringRes stringRes: Int,
    @DrawableRes iconRes: Int
) {
    Parking(stringRes = R.string.parking, iconRes = R.drawable.ic_parking),
    Slope(stringRes = R.string.slope, iconRes = R.drawable.ic_slope),
    Elevator(stringRes = R.string.elevator, iconRes = R.drawable.ic_elevator),
    Lift(stringRes = R.string.lift, iconRes = R.drawable.ic_lift),
    Escalator(stringRes = R.string.escalator, iconRes = R.drawable.ic_escalator),
    Restroom(stringRes = R.string.restroom, iconRes = R.drawable.ic_restroom),
    Shower(stringRes = R.string.shower, iconRes = R.drawable.ic_shower),
    Accommodation(stringRes = R.string.accommodation, iconRes = R.drawable.ic_accommodation),
}
