package com.rodolforuiz.ruiz.rrmovieskmm.auth.login.di

import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.data.LoginDataSource
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.data.LoginRepositoryImpl
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.repository.LoginRepository
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.domain.usecase.GetLoginResultUseCase
import com.rodolforuiz.ruiz.rrmovieskmm.auth.login.presentation.LoginViewModel
import org.koin.dsl.module

val loginModule = module {

    single<LoginViewModel> { LoginViewModel(get() )}
    single<GetLoginResultUseCase> { GetLoginResultUseCase(get()) }
    single<LoginDataSource> { LoginDataSource() }
    single<LoginRepository> { LoginRepositoryImpl(get(), get()) }

}