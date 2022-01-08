package com.data.storage.sharepref

import android.content.Context
import android.content.SharedPreferences
import com.data.storage.UserStorage

private const val USER_SHARED_PREFERENCES = "user_shared_pref"
private const val USER_CALCULATION_TYPE = "user_calculation_type"
private const val USER_EPD = "user_epd"
private const val USER_PPD = "user_ppd"
private const val USER_STARTED_TIME = "user_started_time"
private const val USER_STARTED = "user_started"
private const val USER_PAUSED = "user_paused"
private const val USER_PAUSED_TIME = "user_paused_time"
private const val USER_PAUSED_START_TIME = "user_paused_start_time"

class SharedPrefUserStorage(
    context: Context
) : UserStorage {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(USER_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun saveType(type: Boolean): Boolean {
        return sharedPreferences.edit().putBoolean(USER_CALCULATION_TYPE, type).commit()
    }

    override fun getType(): Boolean {
        return sharedPreferences.getBoolean(USER_CALCULATION_TYPE, true)

    }

    override fun saveEPD(EPD: Int): Boolean {
        return sharedPreferences.edit().putInt(USER_EPD, EPD).commit()
    }

    override fun getEPD(): Int {
        return sharedPreferences.getInt(USER_EPD, 0)
    }

    override fun savePPD(PPD: Int): Boolean {
        return sharedPreferences.edit().putInt(USER_PPD, PPD).commit()
    }

    override fun getPPD(): Int {
        return sharedPreferences.getInt(USER_PPD, 0)
    }

    override fun saveStartedTime(startedTime: Long): Boolean {
        return sharedPreferences.edit().putLong(USER_STARTED_TIME, startedTime).commit()
    }

    override fun getStartedTime(): Long {
        return sharedPreferences.getLong(USER_STARTED_TIME, 0L)
    }

    override fun saveStarted(started: Boolean): Boolean {
        return sharedPreferences.edit().putBoolean(USER_STARTED, started).commit()
    }

    override fun getStarted(): Boolean {
        return sharedPreferences.getBoolean(USER_STARTED, false)
    }

    override fun savePaused(paused: Boolean): Boolean {
        return sharedPreferences.edit().putBoolean(USER_PAUSED, paused).commit()
    }

    override fun getPaused(): Boolean {
        return sharedPreferences.getBoolean(USER_PAUSED, false)
    }

    override fun savePausedTime(time: Long): Boolean {
        return sharedPreferences.edit().putLong(USER_PAUSED_TIME, time).commit()
    }

    override fun getPausedTime(): Long {
        return sharedPreferences.getLong(USER_PAUSED_TIME, 0L)
    }

    override fun savePausedStartTime(time: Long): Boolean {
        return sharedPreferences.edit().putLong(USER_PAUSED_START_TIME, time).commit()
    }

    override fun getPausedStartTime(): Long {
        return sharedPreferences.getLong(USER_PAUSED_START_TIME, 0L)
    }
}