package com.rodolforuiz.ruiz.rrmovieskmm.detail.di

import com.rodolforuiz.ruiz.rrmovieskmm.detail.presentation.DetailViewModel
import org.koin.dsl.module

val detailModule = module {
    single<DetailViewModel> { DetailViewModel() }
}