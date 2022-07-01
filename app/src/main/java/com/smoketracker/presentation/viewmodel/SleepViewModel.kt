package com.smoketracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.usecases.GetSmokingStatusUsecase
import com.domain.usecases.SaveSleepTimeUsecase
import com.domain.usecases.SaveVolumeUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SleepViewModel @Inject constructor(
    private val saveSleepTimeUsecase: SaveSleepTimeUsecase,
) : ViewModel() {

    private val _sleepTime = MutableLiveData<String>()
    val sleepTime: LiveData<String> = _sleepTime

    fun saveSleepTime(time: String) {
        saveSleepTimeUsecase.execute(time.toInt())
    }

    fun updateSleepTime(time: String) {
        _sleepTime.value = time
    }
}