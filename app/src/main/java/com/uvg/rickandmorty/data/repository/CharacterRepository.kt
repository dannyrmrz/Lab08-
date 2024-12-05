// CharacterRepository.kt
package com.uvg.rickandmorty.data.repository

import com.uvg.rickandmorty.data.model.CharacterEntity
import com.uvg.rickandmorty.data.source.CharacterDao

class CharacterRepository(private val characterDao: CharacterDao) {
    suspend fun insertAll(characters: List<CharacterEntity>) {
        characterDao.insertAll(characters)
    }

    suspend fun getAll(): List<CharacterEntity> {
        return characterDao.getAll()
    }

    suspend fun getById(id: Int): CharacterEntity {
        return characterDao.getById(id)
    }
}