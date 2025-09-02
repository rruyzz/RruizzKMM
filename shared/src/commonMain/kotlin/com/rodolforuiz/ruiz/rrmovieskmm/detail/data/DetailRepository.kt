package com.rodolforuiz.ruiz.rrmovieskmm.detail.data

import com.rodolforuiz.ruiz.rrmovieskmm.detail.domain.DetailModel

class DetailRepository(
    private val service: DetailService
) {
    suspend fun getPopularMovie(movieId: String): DetailModel {
        return try {
            val r = service.getDetails(movieId)
            println("Rodolfeira ${r}")
            r.toDomain()
        } catch (e: Exception) {
            println("Rodolfeira ${e}")
            DetailMovieResponse().toDomain()
        }
    }

    private fun DetailMovieResponse.toDomain() = DetailModel(
        isSaved = false,
        title = this.title.orEmpty(),
        backgroundPoster = this.backgroundPoster.orEmpty(),
        poster = this.poster.orEmpty(),
        grade = this.grade.toString(),
        year = this.year.orEmpty(),
        minute = this.minute.toString(),
        gender = this.gender.toString(),
        description = this.description.orEmpty()
    )
}