package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie

data class HomeState(
    val movies: List<Movie> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)