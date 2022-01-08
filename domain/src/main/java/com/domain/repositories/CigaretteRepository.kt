package com.domain.repositories

import com.domain.model.Cigarette

interface CigaretteRepository {
    fun saveVolume(volume: Int): Boolean
    fun getVolume(): Int
    fun savePrice(price: Int): Boolean
    fun getCigarette(): Cigarette
    fun saveSmoked(smoked: Int): Boolean
    fun getSmoked(): Int
    fun clearData(): Boolean
}