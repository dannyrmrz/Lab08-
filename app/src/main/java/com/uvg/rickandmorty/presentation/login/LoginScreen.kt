// LoginScreen.kt
package com.uvg.rickandmorty.presentation.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danny.RickAndMorty.R
import com.uvg.rickandmorty.presentation.ui.theme.RickAndMortyTheme

@Composable
fun LoginRoute(
    onLoginClick: (String) -> Unit,
) {
    var userName by remember { mutableStateOf("") }

    LoginScreen(
        userName = userName,
        onUserNameChange = { userName = it },
        onLoginClick = { onLoginClick(userName) },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun LoginScreen(
    userName: String,
    onUserNameChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(horizontal = 64.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.rickmorty_logo), contentDescription = "Logo")
            TextField(
                value = userName,
                onValueChange = onUserNameChange,
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Iniciar sesión")
            }
        }
        Text(
            text = "Daniela Ramirez - 23053",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewLoginScreen() {
    RickAndMortyTheme {
        Surface {
            LoginScreen(
                userName = "",
                onUserNameChange = {},
                onLoginClick = { /*TODO*/ },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}