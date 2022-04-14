package com.alexmumo.domain.di

import com.alexmumo.domain.usecases.GetCharacterUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCharacterUseCase(get()) }
}
