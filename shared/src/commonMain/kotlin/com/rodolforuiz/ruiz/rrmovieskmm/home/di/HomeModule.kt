package com.rodolforuiz.ruiz.rrmovieskmm.home.di

import com.rodolforuiz.ruiz.rrmovieskmm.home.data.HomeRepository
import com.rodolforuiz.ruiz.rrmovieskmm.home.data.HomeService
import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.PopularMoviesUseCase
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.HomeViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.factory.HomeFactory
import org.koin.dsl.module

val homeModule = module {

    single<HomeService> { HomeService(get()) }
    single<PopularMoviesUseCase> { PopularMoviesUseCase(get()) }
    single<HomeViewModel> { HomeViewModel(HomeFactory(get())) }
    single<HomeRepository> { HomeRepository(get()) }
}