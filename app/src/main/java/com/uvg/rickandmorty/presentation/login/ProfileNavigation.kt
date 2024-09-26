package com.uvg.rickandmorty.presentation.login


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.uvg.rickandmorty.presentation.character.LocationNavGraph
import com.uvg.rickandmorty.presentation.character.profile.LocationListDestination
import com.uvg.rickandmorty.presentation.character.profile.locationDetailScreen
import com.uvg.rickandmorty.presentation.character.profile.locationListScreen
import com.uvg.rickandmorty.presentation.character.profile.navigateToLocationDetailScreen
import kotlinx.serialization.Serializable

@Serializable
data object ProfileDestination

fun NavGraphBuilder.profileScreen(
    onLogoutClick: () -> Unit
) {
    composable<ProfileDestination> {
        ProfileScreen(
            onLogoutClick = onLogoutClick,
        )
    }
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
