package com.data.storage

interface CigaretteStorage {
    fun saveVolume(volume: Int): Boolean
    fun getVolume(): Int
}