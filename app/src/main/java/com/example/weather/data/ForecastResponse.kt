package com.example.weather.data

/**
 * JSON Response format of a 7 day weather forecast request with hourly temperature (2m) and daily weather codes.
 */
data class ForecastResponse(
    /**
     * WGS84 of the latitude of the weather grid-cell which was used to generate this forecast.
     * This coordinate might be a few kilometers away from the requested coordinate.
     */
    val latitude: Double,
    /**
     * WGS84 of the longitude of the weather grid-cell which was used to generate this forecast.
     * This coordinate might be a few kilometers away from the requested coordinate.
     */
    val longitude: Double,
    /**
     * Generation time of the weather forecast in milliseconds.
     * This is mainly used for performance monitoring and improvements.
     */
    val generationtime_ms: Double,
    /**
     * Applied timezone offset from the &timezone= parameter.
     */
    val utc_offset_seconds: Int,
    /**
     * Timezone identifier (e.g. Europe/Berlin).
     */
    val timezone: String,
    /**
     * Timezone identifier abbreviation (e.g. CEST).
     */
    val timezone_abbreviation: String,
    /**
     * The elevation from a 90 meter digital elevation model.
     * This effects which grid-cell is selected (see parameter cell_selection).
     * Statistical downscaling is used to adapt weather conditions for this elevation.
     * This elevation can also be controlled with the query parameter elevation.
     * If &elevation=nan is specified, all downscaling is disabled and the average grid-cell elevation is used.
     */
    val elevation: Float,
    /**
     * For each selected weather variable, the unit will be listed here.
     */
    val hourly_units: HourlyUnits,
    /**
     * For each selected weather variable, data will be returned as a floating point array.
     * Additionally a time array will be returned with ISO8601 timestamps.
     */
    val hourly: Hourly,
    /**
     * For each selected daily weather variable, the unit will be listed here.
     */
    val daily_units: DailyUnits,
    /**
     * For each selected daily weather variable, data will be returned as a floating point array.
     * Additionally a time array will be returned with ISO8601 timestamps.
     */
    val daily: Daily,
)

/**
 * For each selected weather variable, the unit will be listed here.
 */
data class HourlyUnits(
    val time: String,
    val temperature_2m: String,
)

/**
 * For each selected weather variable, data will be returned as a floating point array.
 * Additionally a time array will be returned with ISO8601 timestamps.
 */
data class Hourly(
    val time: List<String>,
    val temperature_2m: List<Float>,
)

/**
 * For each selected daily weather variable, the unit will be listed here.
 */
data class DailyUnits(
    val time: String,
    val weather_code: String,
)

/**
 * For each selected daily weather variable, data will be returned as a floating point array.
 * Additionally a time array will be returned with ISO8601 timestamps.
 */
data class Daily(
    val time: List<String>,
    val weather_code: List<Int>,
)
