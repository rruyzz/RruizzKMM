package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.BaseViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.PopularMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: PopularMoviesUseCase
) : BaseViewModel() {

    private val _homeState: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState(loading = true))

    val homeState: StateFlow<HomeState> get() = _homeState

    init {
        handleGet()
    }

    private fun handleGet() = scope.launch {
        try {
            _homeState.emit(HomeState(loading = true))
            val nowMovies = useCase.getNowMovies()
            val popularMovie = useCase.getPopularMovie()
            val topRated = useCase.getTopRated()
            _homeState.emit(
                HomeState(
                    nowPlayingList = nowMovies,
                    popularMovies = popularMovie,
                    topRated = topRated,
                    )
            )
        } catch (e: Exception) {
            _homeState.emit(HomeState(error = e.message))
        }
    }

    fun refresh() {
        handleGet()
    }

    private fun getNowMovies() {
        scope.launch {
            try {
                _homeState.emit(HomeState(loading = true))
                val nowMovies = useCase.getNowMovies()
                _homeState.emit(HomeState(nowPlayingList = nowMovies))
            } catch (e: Exception) {
                _homeState.emit(HomeState(error = e.message))
            }
        }
    }

    private fun getPopularMovie() {
        scope.launch {
            try {
                _homeState.emit(HomeState(loading = true))
                val popularMovie = useCase.getPopularMovie()
                _homeState.emit(HomeState(popularMovies = popularMovie))
            } catch (e: Exception) {
                _homeState.emit(HomeState(error = e.message))
            }
        }
    }

    private fun getTopRated() {
        scope.launch {
            try {
                _homeState.emit(HomeState(loading = true))
                val topRated = useCase.getTopRated()
                _homeState.emit(HomeState(topRated = topRated))
            } catch (e: Exception) {
                _homeState.emit(HomeState(error = e.message))
            }
        }
    }
}