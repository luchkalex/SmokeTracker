package com.domain.repositories

import com.domain.model.CalculationType

interface UserRepository {
    fun saveType(type: CalculationType): Boolean
    fun getType(): CalculationType
}