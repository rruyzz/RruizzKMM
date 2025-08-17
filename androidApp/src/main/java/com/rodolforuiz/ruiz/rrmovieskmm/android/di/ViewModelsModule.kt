package com.rodolforuiz.ruiz.rrmovieskmm.android.di

import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.DetailViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { (movie: Movie) ->
        DetailViewModel(
            detailUseCase = get(),
            movie = movie
        )
    }
}