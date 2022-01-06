package com.smoketracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.domain.usecases.GetVolumeUsecase
import com.domain.usecases.SaveVolumeUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val saveVolumeUsecase: SaveVolumeUsecase,
    private val getVolumeUsecase: GetVolumeUsecase
    ) : ViewModel() {

    private val _volume = MutableLiveData<String>()
    val volume: LiveData<String> = _volume

    init {
        getVolume()
    }

    fun saveVolume(volume: String) {
        saveVolumeUsecase.execute(volume.toInt())
    }

    fun updateVolume(volume: String){
        _volume.value = volume
    }

    fun getVolume(){
        _volume.value = getVolumeUsecase.execute().toString()
    }
}