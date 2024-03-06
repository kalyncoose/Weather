package com.example.weather.data

import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoService {
    @GET("forecast")
    suspend fun getForecast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String,
        @Query("daily") daily: String,
        @Query("temperature_unit") temperatureUnit: String,
        @Query("wind_speed_unit") windSpeedUnit: String,
        @Query("precipitation_unit") precipitationUnit: String,
    ): ForecastResponse
}
