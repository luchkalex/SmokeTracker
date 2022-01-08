package com.data.storage

interface UserStorage {
    fun saveType(type: Boolean): Boolean
    fun getType(): Boolean
    fun saveEPD(EPD: Int): Boolean
    fun getEPD(): Int
    fun savePPD(PPD: Int): Boolean
    fun getPPD(): Int
    fun saveStartedTime(startedTime: Long): Boolean
    fun getStartedTime(): Long
    fun saveStarted(started: Boolean): Boolean
    fun getStarted(): Boolean
    fun savePaused(paused: Boolean): Boolean
    fun getPaused(): Boolean
    fun savePausedTime(time: Long): Boolean
    fun getPausedTime(): Long
    fun savePausedStartTime(time: Long): Boolean
    fun getPausedStartTime(): Long
}