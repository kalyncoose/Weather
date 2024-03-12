package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.compose.AppTheme
import com.example.weather.data.WeatherApiClient
import com.example.weather.ui.components.WeatherCard
import com.example.weather.ui.screens.WeatherViewModel

class MainActivity : ComponentActivity() {
    // TODO: Use a better pattern than manually creating a factory (Hilt?)
    private val weatherViewModel by viewModels<WeatherViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras,
                ): T {
                    return WeatherViewModel(WeatherApiClient) as T
                }
            }
        },
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Row(
                        modifier =
                            Modifier.fillMaxHeight(0.2f)
                                .fillMaxWidth()
                                .background(Color.Yellow),
                    ) {
                        Text(text = "Top Row")
                    }
                    Row {
                        WeatherCard(
                            date =
                                weatherViewModel.weatherData.value?.hourly?.time?.get(
                                    0,
                                ),
                            temperature =
                                weatherViewModel.weatherData.value?.hourly?.temperature_2m?.get(
                                    0,
                                ),
                            temperatureUnit = weatherViewModel.weatherData.value?.hourly_units?.temperature_2m,
                            weatherCode =
                                weatherViewModel.weatherData.value?.daily?.weather_code?.get(
                                    0,
                                ),
                        )
                    }
                    Row(
                        modifier =
                            Modifier.fillMaxHeight(0.2f)
                                .fillMaxWidth()
                                .background(Color.Yellow),
                    ) {
                        Text(text = "Bottom Row")
                    }
                }
            }
        }
    }
}
