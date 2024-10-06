package com.uvg.rickandmorty.presentation.character.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.rickandmorty.data.source.CharacterDb
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterProfileViewModel(private val characterId: Int) : ViewModel() {
    private val _state = MutableStateFlow(CharacterProfileState(isLoading = true))
    val state: StateFlow<CharacterProfileState> = _state

    init {
        loadCharacter()
    }

    private fun loadCharacter() {
        viewModelScope.launch {
            delay(2000) // Simulate loading
            _state.value = CharacterProfileState(data = CharacterDb().getCharacterById(characterId))
        }
    }

    fun retry() {
        _state.value = CharacterProfileState(isLoading = true)
        loadCharacter()
    }

    fun setError() {
        _state.value = CharacterProfileState(hasError = true)
    }
}