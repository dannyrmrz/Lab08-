package com.uvg.rickandmorty.presentation.character.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LocationDetailViewModelFactory(private val locationId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LocationDetailViewModel::class.java)) {
            return LocationDetailViewModel(locationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}