package com.alexmumo.rickymorty.presentation.di

import com.alexmumo.rickymorty.presentation.ui.screens.details.DetailsViewModel
import com.alexmumo.rickymorty.presentation.ui.screens.home.HomeViewModel
import com.alexmumo.rickymorty.presentation.ui.screens.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get(), get()) }
    viewModel { SearchViewModel(get()) }
}
