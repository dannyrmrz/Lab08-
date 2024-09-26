package com.uvg.rickandmorty.data.source

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
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

