package com.uvg.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.uvg.rickandmorty.presentation.navigation.AppNavigation
import com.uvg.rickandmorty.presentation.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                AppNavigation(modifier = Modifier.fillMaxSize())
            }
        }
    }
}