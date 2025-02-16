package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.factory

import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.PopularMoviesUseCase
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.model.HomeSuccessContent

class HomeFactory(private val useCase: PopularMoviesUseCase) {

    suspend operator fun invoke(): HomeSuccessContent {
        val nowMovies = useCase.getNowMovies()
        val popularMovie = useCase.getPopularMovie()
        val topRated = useCase.getTopRated()
        return HomeSuccessContent(
            title = "What do you want to watch?",
            popularMovies = popularMovie,
            nowPlayingList = nowMovies,
            topRated = topRated,
        )
    }
}