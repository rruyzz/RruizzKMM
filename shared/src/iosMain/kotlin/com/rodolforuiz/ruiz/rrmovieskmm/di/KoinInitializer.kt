package com.rodolforuiz.ruiz.rrmovieskmm.di

import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.DetailViewModel
import com.rodolforuiz.ruiz.rrmovieskmm.home.presentation.HomeViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {

    val modules = sharedKoinModules

    startKoin {
        modules(modules)
    }
}

class HomeInjector : KoinComponent {

    val homeViewModel: HomeViewModel by inject()
    val detailViewModel: DetailViewModel by inject()
}