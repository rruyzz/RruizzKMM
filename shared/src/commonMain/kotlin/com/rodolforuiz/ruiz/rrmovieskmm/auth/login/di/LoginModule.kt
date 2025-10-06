package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.di

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.data.LoginDataSource
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.data.LoginRepositoryImpl
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository.LoginRepository
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.provider.LoginProvider
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.presentation.LoginViewModel
import org.koin.dsl.module

val loginModule = module {

    single<LoginViewModel> { LoginViewModel(get() )}
    single<LoginProvider> { LoginProvider(get()) }
    single<LoginDataSource> { LoginDataSource(get()) }
    single<LoginRepository> { LoginRepositoryImpl(get(), get()) }

}