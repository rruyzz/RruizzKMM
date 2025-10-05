package com.rodolforuiz.ruiz.rrmovieskmm.di

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.di.loginModule
import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.di.tokenModule
import com.rodolforuiz.ruiz.rrmovieskmm.detail.di.detailModule
import com.rodolforuiz.ruiz.rrmovieskmm.home.di.homeModule
import com.rodolforuiz.ruiz.rrmovieskmm.main.di.mainModule

val sharedKoinModules = listOf(
    homeModule,
    detailModule,
    loginModule,
    mainModule,
    tokenModule,
    networkModule
)