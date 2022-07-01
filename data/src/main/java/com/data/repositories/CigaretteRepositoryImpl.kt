package com.data.repositories

import com.data.storage.CigaretteStorage
import com.domain.model.Cigarette
import com.domain.repositories.CigaretteRepository

class CigaretteRepositoryImpl(
    private val cigaretteStorage: CigaretteStorage,
    private val localCigaretteStorage: CigaretteStorage,
    ) :
    CigaretteRepository {

    override fun saveVolume(volume: Int): Boolean {
        return cigaretteStorage.saveVolume(volume)
    }

    override fun getVolume(): Int {
        return cigaretteStorage.getVolume()
    }

    override fun savePrice(price: Int): Boolean {
        return cigaretteStorage.savePrice(price)
    }

    override fun getCigarette(): Cigarette {
        return Cigarette(
            volume = cigaretteStorage.getVolume(),
            smoked = cigaretteStorage.getSmoked(),
            prise = cigaretteStorage.getPrice()
        )
    }

    override fun saveSmoked(smoked: Int): Boolean {
        return cigaretteStorage.saveSmoked(smoked)
    }

    override fun getSmoked(): Int {
        return cigaretteStorage.getSmoked()
    }

    override fun clearData(): Boolean {
        return (cigaretteStorage.saveSmoked(0) &&
                cigaretteStorage.savePrice(0) &&
                cigaretteStorage.saveVolume(0))
    }
}