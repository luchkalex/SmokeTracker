package com.data.repositories

import com.data.storage.UserStorage
import com.domain.model.CalculationType
import com.domain.model.User
import com.domain.repositories.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) :
    UserRepository {

    override fun saveType(type: CalculationType): Boolean {
        return userStorage.saveType(type.type)
    }

    override fun getType(): CalculationType {
        return CalculationType.toCalculationType(userStorage.getType())
    }

    override fun saveEPD(EPD: Int): Boolean {
        return userStorage.saveEPD(EPD)
    }

    override fun savePPD(PPD: Int): Boolean {
        return userStorage.savePPD(PPD)
    }

    override fun getUser(): User {
        return User(
            started = userStorage.getStarted(),
            EPD = userStorage.getEPD(),
            PPD = userStorage.getPPD(),
            startedTime = userStorage.getStartedTime(),
            type = CalculationType.toCalculationType(userStorage.getType()),
            pausedStartTime = userStorage.getPausedStartTime(),
            paused = userStorage.getPaused(),
            pausedTime = userStorage.getPausedTime()
        )
    }

    override fun updateSmokingStatus(smoking: Boolean) {
        userStorage.saveStarted(smoking)
    }

    override fun getSmokingStatus(): Boolean {
        return userStorage.getStarted()
    }

    override fun saveStartedTime(time: Long): Boolean {
        return userStorage.saveStartedTime(time)
    }

    override fun getStartedTime(): Long {
        return userStorage.getStartedTime()
    }

    override fun clearData(): Boolean {
        return (userStorage.saveStartedTime(0) &&
                userStorage.saveEPD(0) &&
                userStorage.savePPD(0) &&
                userStorage.saveStarted(false) &&
                userStorage.saveType(CalculationType.EPD.type) &&
                userStorage.savePaused(false) &&
                userStorage.savePausedStartTime(0) &&
                userStorage.savePausedTime(0))
    }

    override fun pauseSmoking(time: Long): Boolean {
        return (userStorage.savePausedStartTime(time) &&
                userStorage.savePaused(true))
    }

    override fun continueSmoking(time: Long): Boolean {
        return (userStorage.savePaused(false) &&
                userStorage.savePausedTime(
                    userStorage.getPausedTime() +
                            time -
                            userStorage.getPausedStartTime()
                ) &&
                userStorage.savePausedStartTime(0))
    }

    override fun sleep(time: Int): Boolean {
        return userStorage.savePausedTime(userStorage.getPausedTime() + time.toLong() * 60000)
    }
}