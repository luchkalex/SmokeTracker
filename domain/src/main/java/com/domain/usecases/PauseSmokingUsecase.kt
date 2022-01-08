package com.domain.usecases

import com.domain.repositories.UserRepository

class PauseSmokingUsecase(private val userRepository: UserRepository) {
    fun execute(): Boolean {
        return userRepository.pauseSmoking(System.currentTimeMillis())
    }
}