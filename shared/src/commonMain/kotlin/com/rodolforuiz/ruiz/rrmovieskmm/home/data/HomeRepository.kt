package com.rodolforuiz.ruiz.rrmovieskmm.home.data

import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie

class HomeRepository(
    private val service: HomeService
) {
    suspend fun getPopularMovie() : List<Movie> {
        return service.getPopularMovies().results?.map {
            Movie(title = it.titleMovie.orEmpty(), image = it.posterPath.orEmpty())
        } ?: listOf()
    }
}