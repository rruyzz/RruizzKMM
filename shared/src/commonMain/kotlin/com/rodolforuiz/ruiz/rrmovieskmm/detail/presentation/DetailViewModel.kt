package com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.BaseViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.detail.domain.GetDetailUseCase
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.model.DetailContent
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val detailUseCase: GetDetailUseCase,
    private val movie: Movie
): BaseViewModel() {
    private val _detailState: MutableStateFlow<DetailState> =
        MutableStateFlow(DetailState(loading = true))

    val detailState: StateFlow<DetailState> get() = _detailState

    init {
        loadMovie()
    }
    fun loadMovie() = scope.launch {
        try {
            _detailState.emit(DetailState(loading = true))
            val detailContent = detailUseCase.getDetailsMovies(movieId = movie.id)
            _detailState.emit(
                DetailState(successState = detailContent)
            )
        } catch (e: Exception) {
            _detailState.emit(DetailState(error = e.message))
        }
    }
}