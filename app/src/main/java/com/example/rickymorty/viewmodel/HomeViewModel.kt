package com.example.rickymorty.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usescases.GetCharacterUseCase

class HomeViewModel constructor(private val characterUseCase: GetCharacterUseCase) : ViewModel() {

}
