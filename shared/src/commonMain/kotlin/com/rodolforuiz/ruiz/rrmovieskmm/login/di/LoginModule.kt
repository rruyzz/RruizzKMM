package com.rodolforuiz.ruiz.rrmovieskmm.login.di

import com.rodolforuiz.ruiz.rrmovieskmm.home.domain.PopularMoviesUseCase
import com.rodolforuiz.ruiz.rrmovieskmm.login.data.LoginRepositoryImpl
import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.repository.login.LoginRepository
import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.usecase.GetLoginStatusUseCase
//import com.rodolforuiz.ruiz.rrmovieskmm.login.domain.usecase.GetLoginStatusUseCase
import com.rodolforuiz.ruiz.rrmovieskmm.login.presentation.LoginViewModel
import org.koin.dsl.module

val loginModule = module {

    single<LoginViewModel> { LoginViewModel(get() )}
    single<GetLoginStatusUseCase> { GetLoginStatusUseCase(get()) }
    single<LoginRepository> { LoginRepositoryImpl() }

}