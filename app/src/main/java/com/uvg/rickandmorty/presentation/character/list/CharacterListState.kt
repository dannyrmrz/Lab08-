package com.uvg.rickandmorty.presentation.character.list

import com.uvg.rickandmorty.data.model.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val data: List<Character>? = null,
    val hasError: Boolean = false
)