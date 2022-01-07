package com.domain.usecases

import com.domain.repositories.CigaretteRepository
import com.domain.repositories.UserRepository

class SaveExpenseDataUsecase(
    private val userRepository: UserRepository,
    private val cigaretteRepository: CigaretteRepository
) {

    fun execute(EPD: Int, price: Int): Boolean {
        return (userRepository.saveEPD(EPD) && cigaretteRepository.savePrice(price))
    }
}