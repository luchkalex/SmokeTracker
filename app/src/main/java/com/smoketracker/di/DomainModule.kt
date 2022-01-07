package com.smoketracker.di

import com.domain.repositories.CigaretteRepository
import com.domain.repositories.UserRepository
import com.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideSaveVolumeUsecase(cigaretteRepository: CigaretteRepository): SaveVolumeUsecase {
        return SaveVolumeUsecase(cigaretteRepository)
    }

    @Provides
    fun provideGetVolumeUsecase(cigaretteRepository: CigaretteRepository): GetVolumeUsecase {
        return GetVolumeUsecase(cigaretteRepository)
    }

    @Provides
    fun provideSaveTypeUsecase(userRepository: UserRepository): SaveTypeUsecase {
        return SaveTypeUsecase(userRepository)
    }

    @Provides
    fun provideGetTypeUsecase(userRepository: UserRepository): GetTypeUsecase {
        return GetTypeUsecase(userRepository)
    }

    @Provides
    fun provideSaveExpenseDataUsecase(
        userRepository: UserRepository,
        cigaretteRepository: CigaretteRepository
    ): SaveExpenseDataUsecase {
        return SaveExpenseDataUsecase(userRepository, cigaretteRepository)
    }
}