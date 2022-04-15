package com.alexmumo.rickymorty.presentation.di

import com.alexmumo.rickymorty.presentation.ui.screens.details.DetailsViewModel
import com.alexmumo.rickymorty.presentation.screens.details.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get(), get()) }
}
