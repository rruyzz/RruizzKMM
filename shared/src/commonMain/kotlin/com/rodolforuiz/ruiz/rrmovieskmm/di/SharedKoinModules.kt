package com.rodolforuiz.ruiz.rrmovieskmm.di

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.di.loginModule
import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.di.tokenModule
import com.rodolforuiz.ruiz.rrmovieskmm.detail.di.detailModule
import com.rodolforuiz.ruiz.rrmovieskmm.home.di.homeModule

val sharedKoinModules = listOf(
    homeModule,
    detailModule,
    loginModule,
    tokenModule,
    networkModule
)