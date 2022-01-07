package com.smoketracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.usecases.SaveExpenseDataUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EPDViewModel @Inject constructor(
    private val saveExpenseDataUsecase: SaveExpenseDataUsecase,
) : ViewModel() {

    private val _EPD = MutableLiveData<String>()
    val EPD: LiveData<String> = _EPD
    private val _price = MutableLiveData<String>()
    val price: LiveData<String> = _price


    fun saveExpenseData() {
        saveExpenseDataUsecase.execute(
            _EPD.value.toString().toInt(),
            _price.value.toString().toInt()
        )
    }

    fun updatePrice(price: String) {
        _price.value = price
    }

    fun updateEPD(EPD: String) {
        _EPD.value = EPD
    }
}