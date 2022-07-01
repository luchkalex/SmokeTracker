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

    @Provides
    fun provideSavePPDUsecase(userRepository: UserRepository): SavePPDUsecase {
        return SavePPDUsecase(userRepository)
    }

    @Provides
    fun provideGetCigaretteUsecase(
        cigaretteRepository: CigaretteRepository
    ): GetCigaretteUsecase {
        return GetCigaretteUsecase(cigaretteRepository)
    }

    @Provides
    fun provideGetUserUsecase(userRepository: UserRepository): GetUserUsecase {
        return GetUserUsecase(userRepository)
    }

    @Provides
    fun provideUpdateSmokingStatusUsecase(userRepository: UserRepository): UpdateSmokingStatusUsecase {
        return UpdateSmokingStatusUsecase(userRepository)
    }

    @Provides
    fun provideGetSmokingStatusUsecase(userRepository: UserRepository): GetSmokingStatusUsecase {
        return GetSmokingStatusUsecase(userRepository)
    }


    @Provides
    fun provideSaveStartedTimeUsecase(userRepository: UserRepository): SaveStartedTimeUsecase {
        return SaveStartedTimeUsecase(userRepository)
    }

    @Provides
    fun provideClearDataUsecase(
        userRepository: UserRepository,
        cigaretteRepository: CigaretteRepository
    ): ClearDataUsecase {
        return ClearDataUsecase(userRepository, cigaretteRepository)
    }

    @Provides
    fun provideSaveSmokedUsecase(cigaretteRepository: CigaretteRepository): SaveSmokedUsecase {
        return SaveSmokedUsecase(cigaretteRepository)
    }

    @Provides
    fun providePauseSmokingUsecase(userRepository: UserRepository): PauseSmokingUsecase {
        return PauseSmokingUsecase(userRepository)
    }

    @Provides
    fun provideContinueSmokingUsecase(userRepository: UserRepository): ContinueSmokingUsecase {
        return ContinueSmokingUsecase(userRepository)
    }

    @Provides
    fun provideSaveSleepUsecase(userRepository: UserRepository): SaveSleepTimeUsecase {
        return SaveSleepTimeUsecase(userRepository)
    }
}