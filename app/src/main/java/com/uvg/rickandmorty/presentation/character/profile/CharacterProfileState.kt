package com.uvg.rickandmorty.presentation.character.profile

import com.uvg.rickandmorty.data.model.Character

data class CharacterProfileState(
    val isLoading: Boolean = false,
    val data: Character? = null,
    val hasError: Boolean = false
)