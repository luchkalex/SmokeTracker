package com.domain.usecases

import com.domain.repositories.UserRepository

class ContinueSmokingUsecase(private val userRepository: UserRepository) {
    fun execute(): Boolean {
        return userRepository.continueSmoking(System.currentTimeMillis())
    }
}