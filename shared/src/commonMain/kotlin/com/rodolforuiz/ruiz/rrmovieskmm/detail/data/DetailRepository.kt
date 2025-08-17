package com.rodolforuiz.ruiz.rrmovieskmm.detail.data

import com.rodolforuiz.ruiz.rrmovieskmm.detail.domain.DetailModel

class DetailRepository(
    private val service: DetailService
) {
    suspend fun getPopularMovie(movieId: String): DetailModel {
        return service.getDetails(movieId).toDomain()
    }

    private fun DetailMovieResponse.toDomain() = DetailModel(
        isSaved = false,
        title = this.title.orEmpty(),
        backgroundPoster = "https://image.tmdb.org/t/p/w500${this.backdropPath.orEmpty()}",
        poster = "https://image.tmdb.org/t/p/w500${this.posterPath.orEmpty()}",
        grade = this.voteAverage.toString(),
        year = this.releaseDate.orEmpty(),
        minute = this.runtime.toString(),
        gender = this.genres?.firstOrNull().toString(),
        description = this.overview.orEmpty()
    )
}