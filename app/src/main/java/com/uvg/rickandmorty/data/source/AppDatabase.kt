// AppDatabase.kt
package com.uvg.rickandmorty.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uvg.rickandmorty.data.model.CharacterEntity
import com.uvg.rickandmorty.data.model.LocationEntity

@Database(entities = [CharacterEntity::class, LocationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
}