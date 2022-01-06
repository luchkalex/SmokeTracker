package com.data.storage.sharepref

import android.content.Context
import android.content.SharedPreferences
import com.data.storage.CigaretteStorage

private const val CIGARETTE_SHARED_PREFERENCES = "cigarette_shared_pref"
private const val CIGARETTE_VOLUME = "cigarette_volume"

class SharePrefStorage(
    context: Context
) : CigaretteStorage {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(CIGARETTE_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun saveVolume(volume: Int): Boolean {
        sharedPreferences.edit().putInt(CIGARETTE_VOLUME, volume).apply()
        return true
    }

    override fun getVolume(): Int {
        return sharedPreferences.getInt(CIGARETTE_VOLUME, 0)
    }
}