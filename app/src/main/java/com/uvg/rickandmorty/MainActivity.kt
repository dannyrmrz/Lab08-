package com.danny.RickAndMorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.uvg.rickandmorty.presentation.navigation.AppNavigation
import com.uvg.rickandmorty.presentation.ui.theme.RickAndMortyTheme
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.io.File

class MainActivity : ComponentActivity() {
    private val dataStore by lazy { PreferenceDataStoreFactory.create(produceFile = { File(filesDir, "datastore/user_prefs.preferences_pb") }) }
    private val USER_NAME_KEY = stringPreferencesKey("user_name")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                AppNavigation(
                    modifier = Modifier.fillMaxSize(),
                    onLogin = { userName ->
                        lifecycleScope.launch {
                            dataStore.edit { preferences ->
                                preferences[USER_NAME_KEY] = userName
                            }
                        }
                    },
                    isLoggedIn = suspend {
                        val userName = dataStore.data.firstOrNull()?.get(USER_NAME_KEY)
                        userName != null
                    },
                    onLogout = {
                        lifecycleScope.launch {
                            dataStore.edit { preferences ->
                                preferences.remove(USER_NAME_KEY)
                            }
                        }
                    }
                )
            }
        }
    }
}