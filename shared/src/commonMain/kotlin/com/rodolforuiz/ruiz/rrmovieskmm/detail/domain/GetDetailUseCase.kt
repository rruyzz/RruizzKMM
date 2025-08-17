package com.rodolforuiz.ruiz.rrmovieskmm.detail.domain

import com.rodolforuiz.ruiz.rrmovieskmm.detail.data.DetailRepository
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.model.DetailContent

class GetDetailUseCase(private val detailRepository: DetailRepository) {
    suspend fun getDetailsMovies(movieId: String): DetailContent {
        return detailRepository.getPopularMovie(movieId).toDomain()
    }

    private fun DetailModel.toDomain() = DetailContent(
        isSaved = false,
        title = this.title,
        backgroundPoster = this.backgroundPoster,
        poster = this.poster,
        grade = this.grade,
        year = this.year,
        minute = this.minute,
        gender = this.gender,
        description = this.description
    )
}