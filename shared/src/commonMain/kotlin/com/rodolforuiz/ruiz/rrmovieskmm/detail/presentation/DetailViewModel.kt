package com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.BaseViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.model.DetailContent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel: BaseViewModel() {
    private val _detailState: MutableStateFlow<DetailState> =
        MutableStateFlow(DetailState(loading = true))

    val detailState: StateFlow<DetailState> get() = _detailState

    init {
        handleGet()
    }

    private fun handleGet() = scope.launch {
        try {
            _detailState.emit(DetailState(loading = true))
            val content = DetailContent(
                isSaved = true,
                title = "Batman",
                poster = "https://image.tmdb.org/t/p/w500/xSnM4ahmz692msbMTBsfBWHvR3M.jpg",
                backgroundPoster = "https://image.tmdb.org/t/p/w500/zfbjgQE1uSd9wiPTX4VzsLi0rGG.jpg",
                grade = "9.8",
                year = "2020",
                minute = "156 minutes",
                gender = "Batman",
                description = "Batman",
            )
            _detailState.emit(
                DetailState(successState = content)
            )
        } catch (e: Exception) {
            _detailState.emit(DetailState(error = e.message))
        }
    }

}