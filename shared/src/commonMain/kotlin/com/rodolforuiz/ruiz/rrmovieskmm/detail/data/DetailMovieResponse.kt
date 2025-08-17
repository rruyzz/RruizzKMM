package com.rodolforuiz.ruiz.rrmovieskmm.detail.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailMovieResponse(
    @SerialName("adult") val adult: Boolean? = true,
    @SerialName("backdrop_path") val backdropPath: String? = null,
    @SerialName("belongs_to_collection") val belongsToCollection: BelongsToCollection? = null,
    @SerialName("budget") val budget: Int? = 0,
    @SerialName("genres") val genres: List<Genre>? = null,
    @SerialName("homepage") val homepage: String? = null,
    @SerialName("id") val id: Int? = 0,
    @SerialName("imdb_id") val imdbId: String? = null,
    @SerialName("original_language") val originalLanguage: String? = null,
    @SerialName("original_title") val originalTitle: String? = null,
    @SerialName("overview") val overview: String? = null,
    @SerialName("popularity") val popularity: Double? = 0.0,
    @SerialName("poster_path") val posterPath: String? = null,
    @SerialName("production_companies") val productionCompanies: List<ProductionCompany>? = null,
    @SerialName("production_countries") val productionCountries: List<ProductionCountry>? = null,
    @SerialName("release_date") val releaseDate: String? = null,
    @SerialName("revenue") val revenue: Int? = 0,
    @SerialName("runtime") val runtime: Int? = 0,
    @SerialName("spoken_languages") val spokenLanguages: List<SpokenLanguage>? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("tagline") val tagline: String? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("video") val video: Boolean? = true,
    @SerialName("vote_average") val voteAverage: Double? = 0.0,
    @SerialName("vote_count") val voteCount: Int? = 0
)

@Serializable
data class BelongsToCollection(
    @SerialName("id") val id: Int?,
    @SerialName("name") val name: String?,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("backdrop_path") val backdropPath: String?
)

@Serializable
data class Genre(
    @SerialName("id") val id: Int?,
    @SerialName("name") val name: String?
)

@Serializable
data class ProductionCompany(
    @SerialName("id") val id: Int?,
    @SerialName("logo_path") val logoPath: String?,
    @SerialName("name") val name: String?,
    @SerialName("origin_country") val originCountry: String?
)

@Serializable
data class ProductionCountry(
    @SerialName("iso_3166_1") val iso3166_1: String?,
    @SerialName("name") val name: String?
)

@Serializable
data class SpokenLanguage(
    @SerialName("english_name") val englishName: String?,
    @SerialName("iso_639_1") val iso639_1: String?,
    @SerialName("name") val name: String?
)
