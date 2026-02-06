package com.rodolforuiz.ruiz.rrmovieskmm.detail.di

import com.rodolforuiz.ruiz.rrmovieskmm.detail.data.DetailRepository
import com.rodolforuiz.ruiz.rrmovieskmm.detail.data.DetailService
import com.rodolforuiz.ruiz.rrmovieskmm.detail.domain.GetDetailUseCase
import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.DetailViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.Movie
import org.koin.dsl.module

val detailModule = module {
    factory { (movie: Movie) ->
        DetailViewModel(
            movie = movie,
            detailUseCase = get()
        )
    }
    single<GetDetailUseCase> { GetDetailUseCase(get()) }
    single<DetailRepository> { DetailRepository(get()) }
    single<DetailService> { DetailService(get()) }
}