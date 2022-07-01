package com.domain.repositories

import com.domain.model.CalculationType
import com.domain.model.User

interface UserRepository {
    fun saveType(type: CalculationType): Boolean
    fun getType(): CalculationType
    fun saveEPD(EPD: Int): Boolean
    fun savePPD(PPD: Int): Boolean
    fun getUser(): User
    fun updateSmokingStatus(smoking: Boolean)
    fun getSmokingStatus(): Boolean
    fun saveStartedTime(time: Long): Boolean
    fun getStartedTime(): Long
    fun clearData(): Boolean
    fun pauseSmoking(time: Long): Boolean
    fun continueSmoking(time: Long): Boolean
    fun sleep(time: Int): Boolean
}