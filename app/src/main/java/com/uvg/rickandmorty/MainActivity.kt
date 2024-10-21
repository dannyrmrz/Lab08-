// MainActivity.kt
package com.uvg.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uvg.rickandmorty.presentation.character.characterGraph
import com.uvg.rickandmorty.presentation.character.locationGraph
import com.uvg.rickandmorty.presentation.login.loginScreen
import com.uvg.rickandmorty.presentation.login.profileScreen
import com.uvg.rickandmorty.presentation.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        loginScreen { userName ->
                            navController.navigate("profile/$userName")
                        }
                    }
                    composable("profile/{userName}") { backStackEntry ->
                        val userName = backStackEntry.arguments?.getString("userName") ?: ""
                        profileScreen(userName = userName, onLogoutClick = {
                            navController.navigate("login") {
                                popUpTo(navController.graph.startDestinationId) {
                                    inclusive = true
                                }
                            }
                        })
                    }
                    characterGraph(navController)
                    locationGraph(navController)
                }
            }
        }
    }
}