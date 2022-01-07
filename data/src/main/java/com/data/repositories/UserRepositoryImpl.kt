package com.data.repositories

import com.data.storage.UserStorage
import com.domain.model.CalculationType
import com.domain.repositories.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) :
    UserRepository {

    override fun saveType(type: CalculationType): Boolean {
        return userStorage.saveType(type.type)
    }

    override fun getType(): CalculationType {
        return CalculationType.toCalculationType(userStorage.getType())
    }
}