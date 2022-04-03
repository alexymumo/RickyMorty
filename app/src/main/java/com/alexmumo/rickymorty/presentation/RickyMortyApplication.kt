package com.alexmumo.rickymorty.presentation

import android.app.Application
import com.alexmumo.rickymorty.data.network.di.networkModule
import com.alexmumo.rickymorty.data.repository.di.repositoryModule
import com.alexmumo.rickymorty.domain.di.domainModule
import com.alexmumo.rickymorty.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class RickyMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(level = Level.NONE)
            androidContext(this@RickyMortyApplication)
            modules(listOf(networkModule, repositoryModule, presentationModule, domainModule))
        }
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
