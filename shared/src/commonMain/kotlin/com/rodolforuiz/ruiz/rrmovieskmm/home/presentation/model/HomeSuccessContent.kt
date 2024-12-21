package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.model

import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie


data class HomeSuccessContent(
    val title: String,
    val popularMovies: List<Movie> = listOf(),
    val nowPlayingList: List<Movie> = listOf(),
    val topRated: List<Movie> = listOf(),
    val searchText: String = "Search",
)