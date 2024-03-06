package com.example.weather.data

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {
    private const val BASE_URL = "https://api.open-meteo.com/v1/"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val ApiService = retrofit.create(OpenMeteoService::class.java)

    /**
     * Get a 7 day forecast with hourly temperature (2m) and daily weather codes.
     */
    suspend fun get7DayForecast(
        latitude: Double = 52.52,
        longitude: Double = 13.41,
    ): ForecastResponse {
        val forecastResponse: ForecastResponse =
            ApiService.getForecast(
                latitude = latitude,
                longitude = longitude,
                hourly = "temperature_2m",
                daily = "weather_code",
                temperatureUnit = "fahrenheit",
                windSpeedUnit = "mph",
                precipitationUnit = "inch",
            )
        // Handle the response
        Log.v("[Weather]", "forecastResponse=$forecastResponse")
        return forecastResponse
    }
}
