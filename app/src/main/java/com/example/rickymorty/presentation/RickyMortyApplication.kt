package com.example.rickymorty.presentation

import android.app.Application
import timber.log.Timber

class RickyMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
    }
    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
