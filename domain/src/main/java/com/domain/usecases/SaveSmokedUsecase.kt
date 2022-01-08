package com.domain.usecases

import com.domain.repositories.CigaretteRepository

class SaveSmokedUsecase(private val cigaretteRepository: CigaretteRepository) {
    fun execute(smoked: Int): Boolean {
        return cigaretteRepository.saveSmoked(smoked)
    }
}