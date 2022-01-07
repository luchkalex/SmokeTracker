package com.smoketracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.model.CalculationType
import com.domain.usecases.GetTypeUsecase
import com.domain.usecases.GetVolumeUsecase
import com.domain.usecases.SaveTypeUsecase
import com.domain.usecases.SaveVolumeUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TypeViewModel @Inject constructor(
    private val saveTypeUsecase: SaveTypeUsecase,
    private val getTypeUsecase: GetTypeUsecase
    ) : ViewModel() {

    fun onClick(calculationType: CalculationType){
        saveTypeUsecase.execute(calculationType)
    }
}