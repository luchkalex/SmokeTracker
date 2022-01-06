package com.domain.usecases

import com.domain.repositories.CigaretteRepository

class GetVolumeUsecase (private val cigaretteRepository: CigaretteRepository) {
    fun execute(): Int{
        return cigaretteRepository.getVolume()
    }
}