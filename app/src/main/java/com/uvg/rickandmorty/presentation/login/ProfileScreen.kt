// ProfileScreen.kt
package com.uvg.rickandmorty.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danny.RickAndMorty.R
import kotlinx.coroutines.flow.first

@Composable
fun ProfileRoute(
    navController: NavController,
    userName: String
) {
    ProfileScreen(
        userName = userName,
        onLogoutClick = { navController.navigate("LoginScreen") }
    )
}

@Composable
fun ProfileScreen(
    userName: String,
    onLogoutClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.profileimg),
            contentDescription = "Profile Image",
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Nombre Completo: $userName")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onLogoutClick) {
            Text(text = "Cerrar sesión")
        }
    }
}