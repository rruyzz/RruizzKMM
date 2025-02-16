package com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation

import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.model.DetailContent

data class DetailState(
    val successState: DetailContent? = null,
    val loading: Boolean = false,
    val error: String? = null,
)