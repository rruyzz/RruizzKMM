package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie

data class HomeState(
    val popularMovies: List<Movie> = listOf(),
    val nowPlayingList: List<Movie> = listOf(),
    val topRated: List<Movie> = listOf(),
    val searchText: String = "Search",
    val loading: Boolean = false,
    val error: String? = null,
)