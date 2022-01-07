package com.domain.repositories

interface CigaretteRepository {
    fun saveVolume(volume: Int): Boolean
    fun getVolume(): Int
    fun savePrice(price: Int): Boolean
}