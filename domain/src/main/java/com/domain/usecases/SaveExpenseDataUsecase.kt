package com.domain.usecases

import com.domain.repositories.CigaretteRepository
import com.domain.repositories.UserRepository
import kotlin.math.roundToInt

class SaveExpenseDataUsecase(
    private val userRepository: UserRepository,
    private val cigaretteRepository: CigaretteRepository
) {

    fun execute(EPD: Int, price: Int): Boolean {
        val volume = cigaretteRepository.getVolume()
        val PPD = (volume.toDouble() / (price.toDouble() / EPD.toDouble())).roundToInt()
        return (userRepository.saveEPD(EPD) &&
                userRepository.savePPD(PPD) &&
                cigaretteRepository.savePrice(price))
    }
}