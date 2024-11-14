package com.rodolforuiz.ruiz.rrmovieskmm.home.domain

import com.rodolforuiz.ruiz.rrmovieskmm.home.data.HomeRepository

class PopularMoviesUseCase(private val repository: HomeRepository) {

    suspend fun getPopularMovie() : List<Movie> {
        return repository.getPopularMovie()
    }
    suspend fun getNowMovies() : List<Movie> {
        return repository.getNowMovies()
    }
    suspend fun getTopRated() : List<Movie> {
        return repository.getTopRated()
    }
}