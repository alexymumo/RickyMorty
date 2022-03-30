package com.alexmumo.rickymorty.data.repository.di

import com.alexmumo.rickymorty.data.repository.datasource.CharacterRepositoryImpl
import com.alexmumo.rickymorty.domain.repositories.CharacterRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
}
