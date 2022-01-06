package com.domain.usecases

import com.domain.repositories.CigaretteRepository

class SaveVolumeUsecase(private val cigaretteRepository: CigaretteRepository) {
    fun execute(volume: Int): Boolean{
        return cigaretteRepository.saveVolume(volume)
    }
}