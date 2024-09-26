package com.uvg.rickandmorty.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.uvg.rickandmorty.presentation.character.profile.locationListScreen
import com.uvg.rickandmorty.presentation.character.CharacterNavGraph
import com.uvg.rickandmorty.presentation.character.characterGraph
import com.uvg.rickandmorty.presentation.character.navigateToCharacterGraph
import com.uvg.rickandmorty.presentation.login.LoginDestination
import com.uvg.rickandmorty.presentation.login.loginScreen
import com.uvg.rickandmorty.presentation.character.LocationNavGraph
import com.uvg.rickandmorty.presentation.character.list.CharacterListDestination
import com.uvg.rickandmorty.presentation.character.locationGraph
import com.uvg.rickandmorty.presentation.character.profile.LocationListDestination
import com.uvg.rickandmorty.presentation.login.ProfileDestination
import com.uvg.rickandmorty.presentation.login.profileScreen

sealed class Screen(val route: Any, val icon: @Composable () -> Unit, val label: String) {
    object Characters : Screen(CharacterNavGraph, { Icon(Icons.Default.Home, contentDescription = "Characters") }, "Characters")
    object Locations : Screen(LocationNavGraph, { Icon(Icons.Default.Place, contentDescription = "Locations") }, "Locations")
    object Profile : Screen(ProfileDestination, { Icon(Icons.Default.AccountBox, contentDescription = "Profile") }, "Profile")

}

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val bottomNavItems = listOf(Screen.Characters, Screen.Locations, Screen.Profile)
    var isLogged by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(
        bottomBar = {
            when (isLogged){
                true -> NavigationBar {
                    val navBackStackEntry = navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry.value?.destination
                    bottomNavItems.forEach { screen ->
                        NavigationBarItem(
                            icon = screen.icon,
                            label = { Text(screen.label) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(route = screen.route)
                            }
                        )
                    }
                }
                else -> {}
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = LoginDestination,
            modifier = modifier.padding(innerPadding)
        ) {
            loginScreen(
                onLoginClick = {
                    navController.navigateToCharacterGraph()
                    isLogged = true
                }
            )
            profileScreen(onLogoutClick = {
                isLogged = false
                navController.navigate(route = LoginDestination)
                navController.popBackStack(route = CharacterNavGraph, inclusive = false)

            })
            characterGraph(navController)
            locationGraph(navController)
        }
    }
}