package com.rodolforuiz.ruiz.rrmovieskmm.home.data

import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie

class HomeRepository(
    private val service: HomeService
) {
    suspend fun getPopularMovie(): List<Movie> {
        return service.getPopularMovies().results?.map {
            Movie(
                title = it.titleMovie.orEmpty(),
                backdropPath = "https://image.tmdb.org/t/p/w500${it.backdropPath.orEmpty()}",
                posterPath = "https://image.tmdb.org/t/p/w500${it.posterPath.orEmpty()}",
            )
        }?.take(18) ?: listOf()
    }
    suspend fun getNowMovies(): List<Movie> {
        return service.getNowMovies().results?.map {
            Movie(
                title = it.titleMovie.orEmpty(),
                backdropPath = "https://image.tmdb.org/t/p/w500${it.backdropPath.orEmpty()}",
                posterPath = "https://image.tmdb.org/t/p/w500${it.posterPath.orEmpty()}",
            )
        }?.take(18) ?: listOf()
    }
    suspend fun getTopRated(): List<Movie> {
        return service.getTopRated().results?.map {
            Movie(
                title = it.titleMovie.orEmpty(),
                backdropPath = "https://image.tmdb.org/t/p/w500${it.backdropPath.orEmpty()}",
                posterPath = "https://image.tmdb.org/t/p/w500${it.posterPath.orEmpty()}",
            )
        }?.take(18) ?: listOf()
    }
}