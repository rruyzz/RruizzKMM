package com.rodolforuiz.ruiz.rrmovieskmm.home.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.BaseViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.PopularMoviesUseCase
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.factory.HomeFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeFactory: HomeFactory,
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
            val homeSuccessState = homeFactory()
            _homeState.emit(
                HomeState(successState = homeSuccessState)
            )
        } catch (e: Exception) {
            _homeState.emit(HomeState(error = e.message))
        }
    }

    fun refresh() {
        handleGet()
    }
}