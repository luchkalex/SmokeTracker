package com.domain.model

data class User(
    val type: CalculationType,
    val EPD: Int,
    val PPD: Int,
    var startedTime: Long,
    var started: Boolean,
    var paused: Boolean,
    var pausedTime: Long,
    var pausedStartTime: Long,
)
