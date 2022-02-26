package com.example.rickymorty.data.entity

data class RickyMortyCharacter (
    val info : Info,
    val results : List<CharacterData>
    )
data class CharacterData(
    val name: String,
    val species : String,
    val image: String
    )
data class Info(
    val count : Int,
    val pages: Int,
    val next: String,
    val prev : String
    )


