package com.rodolforuiz.ruiz.rrmovieskmm.di

import com.rodolforuiz.ruiz.rrmovieskmm.home.di.homeModule

val sharedKoinModules = listOf(
    homeModule,
    networkModule
)