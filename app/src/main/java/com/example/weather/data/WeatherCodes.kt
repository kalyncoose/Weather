package com.example.weather.data

/**
 * WMO Weather interpretation codes (WW).
 */
enum class WeatherCodes(val code: Int) {
    // Sky
    CLEAR_SKY(0),
    MAINLY_CLEAR(1),

    // Cloud
    PARTLY_CLOUDY(2),
    OVERCAST(3),

    // Fog
    FOG(45),
    DEPOSITING_RIME_FOG(48),

    // Drizzle
    DRIZZLE_LIGHT(51),
    DRIZZLE_MODERATE(53),
    DRIZZLE_DENSE(55),
    FREEZING_DRIZZLE_LIGHT(56),
    FREEZING_DRIZZLE_DENSE(57),

    // Rain
    RAIN_SLIGHT(61),
    RAIN_MODERATE(63),
    RAIN_HEAVY(65),
    FREEZING_RAIN_LIGHT(66),
    FREEZING_RAIN_HEAVY(67),

    // Snow Fall
    SNOW_FALL_SLIGHT(71),
    SNOW_FALL_MODERATE(73),
    SNOW_FALL_HEAVY(75),
    SNOW_GRAINS(77),

    // Rain Shower
    RAIN_SHOWERS_SLIGHT(80),
    RAIN_SHOWERS_MODERATE(81),
    RAIN_SHOWERS_VIOLENT(82),

    // Snow Shower
    SNOW_SHOWERS_SLIGHT(85),
    SNOW_SHOWERS_HEAVY(86),

    // Thunderstorm
    THUNDERSTORM_SLIGHT_MODERATE(95),
    THUNDERSTORM_HAIL_SLIGHT(96),
    THUNDERSTORM_HAIL_HEAVY(99),
    ;

    companion object {
        /**
         * Get a WeatherCode given its code (weather interpretation code).
         */
        fun fromCode(code: Int): WeatherCodes {
            return entries.find { it.code == code }
                ?: throw InvalidWeatherCodeException("Invalid weather code: $code")
        }
    }
}

/**
 * Exception for when a given code does not resolve to a valid WeatherCode.
 */
class InvalidWeatherCodeException(message: String) : Exception(message)
