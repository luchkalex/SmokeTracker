package com.domain.usecases

import com.domain.repositories.CigaretteRepository
import com.domain.repositories.UserRepository

class ClearDataUsecase(
    private val userRepository: UserRepository,
    private val cigaretteRepository: CigaretteRepository
) {

    fun execute(): Boolean {
        return (userRepository.clearData() &&
                cigaretteRepository.clearData())
    }
}