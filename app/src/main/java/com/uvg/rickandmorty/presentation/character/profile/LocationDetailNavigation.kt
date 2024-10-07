package com.uvg.rickandmorty.presentation.character.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.uvg.rickandmorty.presentation.character.profile.CharacterProfileRoute
import com.uvg.rickandmorty.presentation.location.detail.LocationDetailRoute
import kotlinx.serialization.Serializable

@Serializable
data class LocationDetailDestination(
    val Id: Int
)

fun NavController.navigateToLocationDetailScreen(
    Id: Int,
    navOptions: NavOptions? = null
) {
    this.navigate(
        route = LocationDetailDestination(Id = Id),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.locationDetailScreen(
    onNavigateBack: () -> Unit
) {
    composable<LocationDetailDestination> { backStackEntry ->
        val destination: LocationDetailDestination = backStackEntry.toRoute()
        LocationDetailRoute(
            id = destination.Id,
            onNavigateBack = onNavigateBack
        )
    }
}
