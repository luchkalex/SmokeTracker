package com.smoketracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.usecases.SaveExpenseDataUsecase
import com.domain.usecases.SavePPDUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PPDViewModel @Inject constructor(
    private val savePPDUsecase: SavePPDUsecase
) : ViewModel() {

    private val _PPD = MutableLiveData<String>()
    val PPD: LiveData<String> = _PPD

    fun saveExpenseData() {
        savePPDUsecase.execute(
            _PPD.value.toString().toInt(),
        )
    }

    fun updatePPD(EPD: String) {
        _PPD.value = EPD
    }
}