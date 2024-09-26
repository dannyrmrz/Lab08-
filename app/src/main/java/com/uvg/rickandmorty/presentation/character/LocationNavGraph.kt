package com.uvg.rickandmorty.presentation.character

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import com.uvg.rickandmorty.presentation.character.profile.LocationListDestination
import com.uvg.rickandmorty.presentation.character.profile.locationListScreen
import com.uvg.rickandmorty.presentation.character.profile.locationDetailScreen
import com.uvg.rickandmorty.presentation.character.profile.navigateToLocationDetailScreen
import kotlinx.serialization.Serializable

@Serializable
data object LocationNavGraph

fun NavController.navigateToLocationGraph(navOptions: NavOptions? = null) {
    this.navigate(LocationNavGraph, navOptions)
}

fun NavGraphBuilder.locationGraph(
    navController: NavController
) {
    navigation<LocationNavGraph>(
        startDestination = LocationListDestination
    ) {
        locationListScreen(
            onLocationClick = navController::navigateToLocationDetailScreen
        )
        locationDetailScreen(
            onNavigateBack = navController::navigateUp
        )
    }
}

