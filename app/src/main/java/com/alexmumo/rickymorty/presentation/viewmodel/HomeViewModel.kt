package com.alexmumo.rickymorty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.alexmumo.rickymorty.domain.usescases.GetCharacterUseCase

class HomeViewModel constructor(private val characterUseCase: GetCharacterUseCase) : ViewModel()
