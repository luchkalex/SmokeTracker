package com.smoketracker.di

import com.domain.repositories.CigaretteRepository
import com.domain.usecases.GetVolumeUsecase
import com.domain.usecases.SaveVolumeUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideSaveVolumeUsecase(cigaretteRepository: CigaretteRepository): SaveVolumeUsecase{
        return SaveVolumeUsecase(cigaretteRepository)
    }

    @Provides
    fun provideGetVolumeUsecase(cigaretteRepository: CigaretteRepository): GetVolumeUsecase{
        return GetVolumeUsecase(cigaretteRepository)
    }
}