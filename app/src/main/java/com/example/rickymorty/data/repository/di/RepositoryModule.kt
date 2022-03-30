package com.example.rickymorty.data.repository.di

import com.example.rickymorty.data.repository.datasource.CharacterRepositoryImpl
import com.example.rickymorty.domain.repositories.CharacterRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
}
