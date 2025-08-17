package com.rodolforuiz.ruiz.rrmovieskmm.detail.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailMovieResponse(
    @SerialName("isSaved") val isSaved: Boolean? = true,
    @SerialName("title") val title: String? = null,
    @SerialName("backgroundPoster") val backgroundPoster: String? = null,
    @SerialName("poster") val poster: String? = null,
    @SerialName("grade") val grade: Double? = 0.0,
    @SerialName("year") val year: String? = null,
    @SerialName("minute") val minute: Int? = 0,
    @SerialName("gender") val gender: String? = null,
    @SerialName("description") val description: String? = null,
)

@Serializable
data class Genre(
    @SerialName("id") val id: Int?,
    @SerialName("name") val name: String?
)
