package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation

sealed class TabItem(val title: String) {
    data object NowPlaying : TabItem("Now Playing")
    data object Popular : TabItem("Popular")
    data object TopRated : TabItem("Top rated")
}

val tabItems = listOf(
    TabItem.NowPlaying,
    TabItem.Popular,
    TabItem.TopRated,
)