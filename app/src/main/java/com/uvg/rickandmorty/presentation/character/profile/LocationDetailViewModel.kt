package com.uvg.rickandmorty.presentation.character.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.rickandmorty.data.source.LocationDb
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationDetailViewModel(private val locationId: Int) : ViewModel() {
    private val _state = MutableStateFlow(LocationDetailState(isLoading = true))
    val state: StateFlow<LocationDetailState> = _state

    init {
        loadLocation()
    }

    private fun loadLocation() {
        viewModelScope.launch {
            delay(2000) // Simulate loading
            _state.value = LocationDetailState(data = LocationDb().getLocationById(locationId))
        }
    }

    fun retry() {
        _state.value = LocationDetailState(isLoading = true)
        loadLocation()
    }

    fun setError() {
        _state.value = LocationDetailState(hasError = true)
    }
}