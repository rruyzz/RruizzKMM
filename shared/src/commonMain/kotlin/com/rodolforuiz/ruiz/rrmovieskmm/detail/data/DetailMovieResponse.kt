package com.rodolforuiz.ruiz.rrmovieskmm.detail.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailMovieResponse(
    @SerialName("isSaved") val isSaved: Boolean? = true,
    @SerialName("title") val title: String? = null,
    @SerialName("backdrop_path") val backdropPath: String? = null,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("vote_average") val voteAverage: Double? = 0.0,
    @SerialName("release_date") val releaseDate: String? = null,
    @SerialName("runtime") val runtime: Int? = 0,
    @SerialName("genres") val genres: List<Genre>? = null,
    @SerialName("overview") val overview: String? = null,
)

@Serializable
data class Genre(
    @SerialName("id") val id: Int?,
    @SerialName("name") val name: String?
)
