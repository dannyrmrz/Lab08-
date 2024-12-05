package com.uvg.rickandmorty.presentation.character.profile

import com.uvg.rickandmorty.data.model.Location

data class LocationDetailState(
    val isLoading: Boolean = false,
    val data: Location? = null,
    val hasError: Boolean = false
)