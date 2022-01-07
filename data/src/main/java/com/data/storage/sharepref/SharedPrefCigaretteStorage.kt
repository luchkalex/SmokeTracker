package com.data.storage.sharepref

import android.content.Context
import android.content.SharedPreferences
import com.data.storage.CigaretteStorage

private const val CIGARETTE_SHARED_PREFERENCES = "cigarette_shared_pref"
private const val CIGARETTE_VOLUME = "cigarette_volume"
private const val CIGARETTE_PRICE = "cigarette_price"

class SharePrefCigaretteStorage(
    context: Context
) : CigaretteStorage {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(CIGARETTE_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun saveVolume(volume: Int): Boolean {
        return sharedPreferences.edit().putInt(CIGARETTE_VOLUME, volume).commit()
    }

    override fun getVolume(): Int {
        return sharedPreferences.getInt(CIGARETTE_VOLUME, 0)
    }

    override fun savePrice(price: Int): Boolean {
        return sharedPreferences.edit().putInt(CIGARETTE_PRICE, price).commit()
    }
}