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
        getMovie()
        getPopularMovie()
    }

    fun getMovie() {
        scope.launch {
            _homeState.emit(HomeState(loading = true))

            val fetchedMovies = useCase.getPopularMovie()

            _homeState.emit(HomeState(movies = useCase.getPopularMovie()))
        }
    }

    fun getPopularMovie() {
        scope.launch {
            val fetchedMovies = useCase.getPopularMovie()

            _homeState.emit(HomeState(nowPlayingList = useCase.getPopularMovie()))
        }
    }


}