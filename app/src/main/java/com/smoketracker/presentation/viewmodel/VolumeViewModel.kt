package com.smoketracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.usecases.SaveVolumeUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VolumeViewModel @Inject constructor(
    private val saveVolumeUsecase: SaveVolumeUsecase,
    ) : ViewModel() {

    private val _volume = MutableLiveData<String>()
    val volume: LiveData<String> = _volume

    fun saveVolume(volume: String) {
        saveVolumeUsecase.execute(volume.toInt())
    }

    fun updateVolume(volume: String){
        _volume.value = volume
    }
}