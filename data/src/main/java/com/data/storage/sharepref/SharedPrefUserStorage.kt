package com.data.storage.sharepref

import android.content.Context
import android.content.SharedPreferences
import com.data.storage.UserStorage

private const val USER_SHARED_PREFERENCES = "user_shared_pref"
private const val USER_CALCULATION_TYPE = "user_calculation_type"
private const val USER_EPD = "user_epd"

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
}