package com.uvg.rickandmorty.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Characters") },
            label = { Text("Characters") },
            selected = false,
            onClick = { navController.navigate("characters") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Place, contentDescription = "Locations") },
            label = { Text("Locations") },
            selected = false,
            onClick = { navController.navigate("locations") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = false,
            onClick = { navController.navigate("profile") }
        )
    }
}
