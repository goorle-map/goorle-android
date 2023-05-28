package dev.yjyoon.goorle.ui.post

import dev.yjyoon.goorle.ui.model.FilterType

data class Post(
    val id: Int = 0,
    val thumbnail: String = "https://avatars.githubusercontent.com/u/72238126?v=4",
    val title: String = "숙소 이름",
    val location: String = "서울특별시 광진구",
    val filters: List<FilterType> = listOf(FilterType.Parking, FilterType.Slope)
)
