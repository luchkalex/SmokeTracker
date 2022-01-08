package com.smoketracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.usecases.GetSmokingStatusUsecase
import com.domain.usecases.SaveVolumeUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VolumeViewModel @Inject constructor(
    private val saveVolumeUsecase: SaveVolumeUsecase,
    private val getSmokingStatusUsecase: GetSmokingStatusUsecase,
) : ViewModel() {

    private val _volume = MutableLiveData<String>()
    val volume: LiveData<String> = _volume

    private val _started = MutableLiveData<Boolean>()
    val started: LiveData<Boolean> = _started

    fun saveVolume(volume: String) {
        saveVolumeUsecase.execute(volume.toInt())
    }

    fun updateVolume(volume: String) {
        _volume.value = volume
    }

    fun getSmokingStatus() {
        _started.value = getSmokingStatusUsecase.execute()
    }

}