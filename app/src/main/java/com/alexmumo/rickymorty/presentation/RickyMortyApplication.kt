package com.alexmumo.rickymorty.presentation

import android.app.Application
import com.alexmumo.rickymorty.data.network.di.networkModule
import com.alexmumo.rickymorty.data.repository.di.repositoryModule
import com.alexmumo.rickymorty.presentation.di.presentationModule
import timber.log.Timber

class RickyMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initKoin() {
        val modules = listOf(networkModule, repositoryModule, presentationModule)
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
