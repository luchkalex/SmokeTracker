package com.domain.usecases

import com.domain.repositories.UserRepository

class UpdateSmokingStatusUsecase(private val userRepository: UserRepository) {
    fun execute(smoking: Boolean) {
        return userRepository.updateSmokingStatus(smoking)
    }
}