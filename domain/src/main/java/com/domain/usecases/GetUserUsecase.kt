package com.domain.usecases

import com.domain.model.User
import com.domain.repositories.UserRepository

class GetUserUsecase(private val userRepository: UserRepository) {
    fun execute(): User {
        return userRepository.getUser()
    }
}