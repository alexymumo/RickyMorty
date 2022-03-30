package com.example.rickymorty.domain.di

import com.example.domain.usescases.GetCharacterUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCharacterUseCase(get()) }
}
