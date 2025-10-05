package com.rodolforuiz.ruiz.rrmovieskmm.auth.token.di

import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.data.repository.TokenStorageImpl
import com.rodolforuiz.ruiz.rrmovieskmm.auth.token.domain.repository.TokenStorage
import org.koin.dsl.module

val tokenModule = module {
    single<TokenStorage> { TokenStorageImpl() }
}