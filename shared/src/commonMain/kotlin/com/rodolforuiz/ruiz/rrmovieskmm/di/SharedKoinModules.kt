package com.rodolforuiz.ruiz.rrmovieskmm.di

import com.rodolforuiz.ruiz.rrmovieskmm.detail.di.detailModule
import com.rodolforuiz.ruiz.rrmovieskmm.home.di.homeModule
import com.rodolforuiz.ruiz.rrmovieskmm.login.di.loginModule

val sharedKoinModules = listOf(
    homeModule,
    detailModule,
    loginModule,
    networkModule
)