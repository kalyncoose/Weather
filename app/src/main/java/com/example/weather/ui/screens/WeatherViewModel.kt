package com.example.weather.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.data.ForecastResponse
import com.example.weather.data.WeatherApiClient
import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherApiClient: WeatherApiClient) : ViewModel() {
    // TODO: Use better pattern for private mutable state and public immutable state
    val weatherData = mutableStateOf<ForecastResponse?>(null)

    init {
        getForecast()
    }

    private fun getForecast() {
        viewModelScope.launch {
            val response = weatherApiClient.get7DayForecast()
            weatherData.value = response
        }
    }
}
