package dev.yjyoon.goorle.ui.model

import java.io.Serializable

data class Post(
    val id: String = "",
    val images: List<String> = List(5) { "https://avatars.githubusercontent.com/u/72238126?v=4" },
    val title: String = "숙소 이름",
    val location: String = "서울특별시 광진구",
    val filters: List<FilterType> = listOf(FilterType.Parking, FilterType.Slope),
    val tags: List<ThemeType> = listOf(ThemeType.Hanok, ThemeType.Nature),
    val comments: List<Comment> = List(5) { Comment() },
    val lng: Double = 0.0,
    val lat: Double = 0.0
) : Serializable
