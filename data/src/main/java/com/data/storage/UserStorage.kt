package com.data.storage

interface UserStorage {
    fun saveType(type: Boolean): Boolean
    fun getType(): Boolean
    fun saveEPD(EPD: Int): Boolean
}