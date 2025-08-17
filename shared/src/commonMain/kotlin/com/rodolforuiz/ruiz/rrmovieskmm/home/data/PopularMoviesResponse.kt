package com.rodolforuiz.ruiz.rrmovieskmm.home.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMoviesResponse(
    @SerialName("id") val id: Int?,
    @SerialName("title") val titleMovie: String?,
    @SerialName("backdropPath") val backdropPath: String?,
    @SerialName("posterPath") val posterPath: String?,
)
