package com.data.repositories

import com.data.storage.CigaretteStorage
import com.domain.repositories.CigaretteRepository

class CigaretteRepositoryImpl(private val cigaretteStorage: CigaretteStorage) :
    CigaretteRepository {

    override fun saveVolume(volume: Int): Boolean {
        return cigaretteStorage.saveVolume(volume)
    }

    override fun getVolume(): Int {
        return cigaretteStorage.getVolume()
    }
}