// LoginNavigation.kt
package com.uvg.rickandmorty.presentation.login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.loginScreen(
    onLoginClick: (String) -> Unit
) {
    composable("login") {
        LoginRoute(onLoginClick)
    }
}