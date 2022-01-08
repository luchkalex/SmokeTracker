package com.domain.usecases

import com.domain.repositories.UserRepository

class SavePPDUsecase(
    private val userRepository: UserRepository,
) {

    fun execute(PPD: Int): Boolean {
        return userRepository.savePPD(PPD)
    }
}