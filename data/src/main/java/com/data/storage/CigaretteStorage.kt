package com.data.storage

interface CigaretteStorage {
    fun saveVolume(volume: Int): Boolean
    fun getVolume(): Int
    fun savePrice(price: Int): Boolean
    fun getPrice(): Int
    fun saveSmoked(smoked: Int): Boolean
    fun getSmoked(): Int
}