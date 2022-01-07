package com.smoketracker.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.domain.model.CalculationType
import com.domain.usecases.SaveTypeUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TypeViewModel @Inject constructor(
    private val saveTypeUsecase: SaveTypeUsecase,
    ) : ViewModel() {

    fun saveType(calculationType: CalculationType){
        saveTypeUsecase.execute(calculationType)
    }
}