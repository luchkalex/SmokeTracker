package com.smoketracker.di

import android.content.Context
import com.data.repositories.CigaretteRepositoryImpl
import com.data.storage.CigaretteStorage
import com.data.storage.sharepref.SharePrefStorage
import com.domain.repositories.CigaretteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideCigaretteRepository(cigaretteStorage: CigaretteStorage): CigaretteRepository {
        return CigaretteRepositoryImpl(cigaretteStorage)
    }

    @Provides
    @Singleton
    fun provideCigaretteStorage(@ApplicationContext context: Context): CigaretteStorage {
        return SharePrefStorage(context = context)
    }
}