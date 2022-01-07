package com.domain.model

enum class CalculationType(val type: Boolean) {
    PPD(true),
    EPD(false);

    companion object{
        fun toCalculationType(value: Boolean): CalculationType {
            return if (value == PPD.type) PPD else EPD
        }
    }
}