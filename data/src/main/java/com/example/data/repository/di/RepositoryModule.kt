package com.example.data.repository.di

import com.example.data.repository.datasource.CharacterRepositoryImpl
import com.example.domain.repositories.CharacterRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(get()) }
}
