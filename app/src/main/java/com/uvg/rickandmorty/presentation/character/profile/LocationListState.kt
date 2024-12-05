package com.uvg.rickandmorty.presentation.character.profile

import com.uvg.rickandmorty.data.model.Location

data class LocationListState(
    val isLoading: Boolean = false,
    val data: List<Location>? = null,
    val hasError: Boolean = false
)