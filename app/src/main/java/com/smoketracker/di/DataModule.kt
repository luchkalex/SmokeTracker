package com.smoketracker.di

import android.content.Context
import com.data.repositories.CigaretteRepositoryImpl
import com.data.repositories.UserRepositoryImpl
import com.data.storage.CigaretteStorage
import com.data.storage.UserStorage
import com.data.storage.sharepref.SharePrefCigaretteStorage
import com.data.storage.sharepref.SharedPrefUserStorage
import com.domain.model.User
import com.domain.repositories.CigaretteRepository
import com.domain.repositories.UserRepository
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
        return SharePrefCigaretteStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }
}