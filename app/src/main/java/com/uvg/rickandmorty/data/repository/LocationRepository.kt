// LocationRepository.kt
package com.uvg.rickandmorty.data.repository

import com.uvg.rickandmorty.data.model.LocationEntity
import com.uvg.rickandmorty.data.source.LocationDao

class LocationRepository(private val locationDao: LocationDao) {
    suspend fun insertAll(locations: List<LocationEntity>) {
        locationDao.insertAll(locations)
    }

    suspend fun getAll(): List<LocationEntity> {
        return locationDao.getAll()
    }

    suspend fun getById(id: Int): LocationEntity {
        return locationDao.getById(id)
    }
}