package com.rodolforuiz.ruiz.rrmovieskmm.home.domain

import com.rodolforuiz.ruiz.rrmovieskmm.home.data.HomeRepository

class PopularMoviesUseCase(private val repository: HomeRepository) {

    suspend fun getPopularMovie() : List<Movie> {
        return repository.getPopularMovie()
    }
}