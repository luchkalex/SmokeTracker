package com.domain.usecases

import com.domain.repositories.CigaretteRepository
import com.domain.repositories.UserRepository

class SaveSleepTimeUsecase(private val userRepository: UserRepository) {
    fun execute(time: Int): Boolean{
        return userRepository.sleep(time)
    }
}