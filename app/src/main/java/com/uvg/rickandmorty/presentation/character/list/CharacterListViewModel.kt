package com.uvg.rickandmorty.presentation.character.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.rickandmorty.data.source.CharacterDb
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterListViewModel : ViewModel() {
    private val _state = MutableStateFlow(CharacterListState(isLoading = true))
    val state: StateFlow<CharacterListState> = _state

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            delay(4000) // Simulate loading
            _state.value = CharacterListState(data = CharacterDb().getAllCharacters())
        }
    }

    fun retry() {
        _state.value = CharacterListState(isLoading = true)
        loadCharacters()
    }

    fun setError() {
        _state.value = CharacterListState(hasError = true)
    }
}