// ProfileNavigation.kt
package com.uvg.rickandmorty.presentation.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ProfileDestination

fun NavGraphBuilder.profileScreen(
    userName: String,
    onLogoutClick: () -> Unit
) {
    composable("profile/{userName}") { backStackEntry ->
        val userName = backStackEntry.arguments?.getString("userName") ?: ""
        ProfileScreen(userName = userName, onLogoutClick = onLogoutClick)
    }
}