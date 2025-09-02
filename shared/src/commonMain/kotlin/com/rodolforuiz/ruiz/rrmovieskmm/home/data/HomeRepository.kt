package com.rodolforuiz.ruiz.rrmovieskmm.home.data

import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie

class HomeRepository(
    private val service: HomeService
) {
    suspend fun getPopularMovie(): List<Movie> {
        return try {
            service.getPopularMovies().map {
                Movie(
                    title = it.titleMovie.orEmpty(),
                    backdropPath = it.backdropPath.orEmpty(),
                    posterPath = it.posterPath.orEmpty(),
                    id = it.id.toString()
                )
            }.take(18) ?: listOf()
        } catch (e: Exception) {
            println("Rodolfeira excepetion getPopularMovie ${e}")
            listOf()
        }
    }

    suspend fun getNowMovies(): List<Movie> {
        return try {
            service.getNowMovies().map {
                Movie(
                    title = it.titleMovie.orEmpty(),
                    backdropPath = it.backdropPath.orEmpty(),
                    posterPath = it.posterPath.orEmpty(),
                    id = it.id.toString()
                )
            }.take(18) ?: listOf()
        } catch (e: Exception) {
            println("Rodolfeira excepetion getNowMovies ${e}")
            listOf()
        }
    }

    suspend fun getTopRated(): List<Movie> {
        return try {
            service.getTopRated().map {
                Movie(
                    title = it.titleMovie.orEmpty(),
                    backdropPath = it.backdropPath.orEmpty(),
                    posterPath = it.posterPath.orEmpty(),
                    id = it.id.toString()
                )

            }.take(18) ?: listOf()
        } catch (e: Exception) {
            println("Rodolfeira excepetion getTopRated ${e}")
            listOf()
        }
    }
}