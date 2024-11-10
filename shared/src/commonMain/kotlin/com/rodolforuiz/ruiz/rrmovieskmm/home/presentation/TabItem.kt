package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation


data class TabItem(
    val title: String,
    val id: Int,
)

val tabItems = listOf(
    TabItem(
        title = "Now Playing",
        id = 0,
    ),
    TabItem(
        title = "Popular",
        id = 1
    ),
    TabItem(
        title = "Top rated",
        id = 2,
    ),
)