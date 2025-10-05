package com.rodolforuiz.ruiz.rrmovieskmm.main

import org.koin.dsl.module

val mainModule = module {

    single<MainViewModel> { MainViewModel(get() )}

}