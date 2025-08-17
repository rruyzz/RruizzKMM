package com.rodolforuiz.ruiz.rrmovieskmm.detail.domain

data class DetailModel(
    val isSaved: Boolean,
    val title: String,
    val backgroundPoster: String,
    val poster: String,
    val grade: String,
    val year: String,
    val minute: String,
    val gender: String,
    val description: String,
)