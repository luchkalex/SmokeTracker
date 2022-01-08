package com.smoketracker.utils

import kotlin.math.pow
import kotlin.math.roundToInt

fun Double.round(precision: Int): Double {
    val scale = 10.0.pow(precision.toDouble()).toInt()
    return (this * scale).roundToInt().toDouble() / scale
}