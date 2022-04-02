package com.alexmumo.rickymorty.domain.di

import com.alexmumo.rickymorty.domain.usescases.GetCharacterDetailUseCase
import com.alexmumo.rickymorty.domain.usescases.GetCharacterUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCharacterUseCase(get()) }
    single { GetCharacterDetailUseCase(get()) }
}
