package com.domain.usecases

import com.domain.model.CalculationType
import com.domain.repositories.UserRepository

class SaveStartedTimeUsecase(private val userRepository: UserRepository) {
    fun execute(): Boolean {
        return userRepository.saveStartedTime(System.currentTimeMillis())
    }
}