package com.rodolforuiz.ruiz.rrmovieskmm.home.domain

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: String,
    val title: String,
    val backdropPath: String,
    val posterPath: String,
)