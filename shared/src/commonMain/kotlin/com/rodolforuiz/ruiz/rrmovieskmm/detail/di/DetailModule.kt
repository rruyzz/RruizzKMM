package com.rodolforuiz.ruiz.rrmovieskmm.detail.di

import com.rodolforuiz.ruiz.rrmovieskmm.detail.data.DetailRepository
import com.rodolforuiz.ruiz.rrmovieskmm.detail.data.DetailService
import com.rodolforuiz.ruiz.rrmovieskmm.detail.domain.GetDetailUseCase
import org.koin.dsl.module

val detailModule = module {
    single<GetDetailUseCase> { GetDetailUseCase(get()) }
    single<DetailRepository> { DetailRepository(get()) }
    single<DetailService> { DetailService(get()) }
}