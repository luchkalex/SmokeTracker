package com.smoketracker.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.model.Cigarette
import com.domain.model.User
import com.domain.usecases.*
import com.smoketracker.utils.round
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val MILLS_IN_DAY = 57600000
private const val MINUTES_IN_DAY = 960

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUsecase: GetUserUsecase,
    private val getCigaretteUsecase: GetCigaretteUsecase,
    private val updateSmokingStatusUsecase: UpdateSmokingStatusUsecase,
    private val saveStartedTimeUsecase: SaveStartedTimeUsecase,
    private val saveSmokedUsecase: SaveSmokedUsecase,
    private val clearDataUsecase: ClearDataUsecase,
    private val pauseSmokingUsecase: PauseSmokingUsecase,
    private val continueSmokingUsecase: ContinueSmokingUsecase
) : ViewModel() {

    private val _started = MutableLiveData<Boolean>()
    val started: LiveData<Boolean> = _started

    private val _volumeLeft = MutableLiveData<Int>()
    val volumeLeft: LiveData<Int> = _volumeLeft

    private val _daysLeft = MutableLiveData<Double>()
    val daysLeft: LiveData<Double> = _daysLeft

    private val _balance = MutableLiveData(0)
    val balance: LiveData<Int> = _balance

    private val _paused = MutableLiveData<Boolean>()
    val paused: LiveData<Boolean> = _paused

    private val _updatingPeriod = MutableLiveData<Double>()
    val updatingPeriod: LiveData<Double> = _updatingPeriod

    private lateinit var user: User
    private lateinit var cigarette: Cigarette

    init {
        getData()
        if (user.started) startUpdatingBalance()
    }

    fun reset() {
        clearDataUsecase.execute()
    }


    fun makePuff() {
        cigarette.smoked++
        _volumeLeft.value = _volumeLeft.value?.minus(1)
        _balance.value = _balance.value?.minus(1)
        saveSmokedUsecase.execute(cigarette.smoked + 1)
    }

    fun startSmoking() {
        updateSmokingStatusUsecase.execute(true)
        saveStartedTimeUsecase.execute()
        _started.value = true
        user.started = true
        user.startedTime = System.currentTimeMillis()
        startUpdatingBalance()
    }

    fun pause() {
        pauseSmokingUsecase.execute()
        _paused.value = true
        user.pausedStartTime = System.currentTimeMillis()
        user.paused = true
    }

    fun continueSmoking() {
        continueSmokingUsecase.execute()
        _paused.value = false
        user = getUserUsecase.execute()
        startUpdatingBalance()
    }

    private fun getData() {
        user = getUserUsecase.execute()
        cigarette = getCigaretteUsecase.execute()
        _started.value = user.started
        _volumeLeft.value = cigarette.volume - cigarette.smoked
        _paused.value = user.paused
        _updatingPeriod.value = (MINUTES_IN_DAY.toDouble() / user.PPD.toDouble()).round(2)
        if (user.started)
            updateBalance()
        updateDaysLeft()
    }


    private fun updateDaysLeft() {
        _daysLeft.value = (((volumeLeft.value?.toDouble() ?: 0.0) -
                (_balance.value?.toDouble() ?: 0.0)) /
                user.PPD.toDouble()).round(2)
    }

    private fun startUpdatingBalance() {
        viewModelScope.launch {
            while (!user.paused) {
                delay(1000)
                if (updateBalance())
                    updateDaysLeft()
            }
        }
    }

    private fun updateBalance(): Boolean {
        val lastUpdated = if (user.paused) user.pausedStartTime else System.currentTimeMillis()
        val currentBalance =
            (lastUpdated - user.startedTime - user.pausedTime).toDouble() / (MILLS_IN_DAY / user.PPD) - cigarette.smoked
        if (currentBalance != balance.value?.toDouble() ?: 0.0) {
            _balance.value = currentBalance.toInt()
            return true
        }
        return false
    }
}