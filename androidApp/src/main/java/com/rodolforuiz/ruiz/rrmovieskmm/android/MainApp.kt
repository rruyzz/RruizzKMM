package com.rodolforuiz.ruiz.rrmovieskmm.android

import android.app.Application
import com.rodolforuiz.ruiz.rrmovieskmm.android.di.viewModelsModule
import com.rodolforuiz.ruiz.rrmovieskmm.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@MainApp)
            modules(modules)
        }
    }
}