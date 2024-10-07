// CharacterProfileViewModelFactory.kt
package com.uvg.rickandmorty.presentation.character.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CharacterProfileViewModelFactory(private val characterId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterProfileViewModel::class.java)) {
            return CharacterProfileViewModel(characterId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}