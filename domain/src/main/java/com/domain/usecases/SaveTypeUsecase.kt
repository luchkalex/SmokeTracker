package com.domain.usecases

import com.domain.model.CalculationType
import com.domain.repositories.UserRepository

class SaveTypeUsecase(private val userRepository: UserRepository) {
    fun execute(type: CalculationType): Boolean{
        return userRepository.saveType(type)
    }
}