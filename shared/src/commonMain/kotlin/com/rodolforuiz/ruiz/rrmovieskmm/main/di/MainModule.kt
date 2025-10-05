package com.rodolforuiz.ruiz.rrmovieskmm.main.di

import com.rodolforuiz.ruiz.rrmovieskmm.main.domain.MainProvider
import com.rodolforuiz.ruiz.rrmovieskmm.main.presentation.MainViewModel
import org.koin.dsl.module

val mainModule = module {

    single<MainViewModel> { MainViewModel(get()) }
    single<MainProvider> { MainProvider(get()) }

}