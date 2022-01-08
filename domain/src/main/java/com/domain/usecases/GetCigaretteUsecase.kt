package com.domain.usecases

import com.domain.model.Cigarette
import com.domain.repositories.CigaretteRepository

class GetCigaretteUsecase(private val cigaretteRepository: CigaretteRepository) {
    fun execute(): Cigarette {
        return cigaretteRepository.getCigarette()
    }
}