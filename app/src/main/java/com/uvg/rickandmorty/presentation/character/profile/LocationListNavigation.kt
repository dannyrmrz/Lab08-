package com.uvg.rickandmorty.presentation.character.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.uvg.rickandmorty.presentation.character.list.CharacterListRoute
import com.uvg.rickandmorty.presentation.location.list.LocationListRoute
import kotlinx.serialization.Serializable

@Serializable
data object LocationListDestination

fun NavGraphBuilder.locationListScreen(
    onLocationClick: (Int) -> Unit
) {
    composable<LocationListDestination> {
        LocationListRoute(onLocationClick = onLocationClick)
    }
}