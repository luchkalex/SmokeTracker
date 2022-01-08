package com.domain.usecases

import com.domain.repositories.UserRepository

class GetSmokingStatusUsecase(private val userRepository: UserRepository) {
    fun execute(): Boolean {
        return userRepository.getSmokingStatus()
    }
}