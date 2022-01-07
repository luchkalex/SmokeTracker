package com.domain.usecases

import com.domain.model.CalculationType
import com.domain.repositories.UserRepository

class GetTypeUsecase (private val userRepository: UserRepository) {
    fun execute(): CalculationType{
        return userRepository.getType()
    }
}