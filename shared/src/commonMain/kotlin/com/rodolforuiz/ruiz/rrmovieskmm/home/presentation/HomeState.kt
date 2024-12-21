package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.model.HomeSuccessContent

data class HomeState(
//    val title: String = "What do you want to watch?",
//    val popularMovies: List<Movie> = listOf(),
//    val nowPlayingList: List<Movie> = listOf(),
//    val topRated: List<Movie> = listOf(),
//    val searchText: String = "Search",
    val successState: HomeSuccessContent? = null,
    val loading: Boolean = false,
    val error: String? = null,
)
