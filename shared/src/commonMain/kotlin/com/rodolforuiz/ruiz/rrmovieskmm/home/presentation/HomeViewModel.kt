package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.BaseViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.PopularMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: PopularMoviesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState(loading = true))

    val articlesState: StateFlow<HomeState> get() = _articlesState

    init {
        getMovie()
    }

    fun getMovie() {
        scope.launch {
            _articlesState.emit(HomeState(loading = true))

            val fetchedMovies = useCase.getPopularMovie()

            _articlesState.emit(HomeState(movies = fetchedMovies))
        }
    }
}