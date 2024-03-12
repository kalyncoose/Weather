package com.example.weather.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.weather.data.WeatherCodes
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    date: String?,
    temperature: Float?,
    temperatureUnit: String?,
    weatherCode: Int?,
) {
    val parsedDate =
        date?.let { LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME) }

    Card(
        modifier =
            Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
                .background(Color.Blue),
    ) {
        Text(
            text = "${parsedDate?.dayOfMonth} ${parsedDate?.month}",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "$temperature $temperatureUnit",
                fontSize = 60.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        Text(
            text = "${parsedDate?.dayOfWeek}",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text =
                weatherCode?.let { WeatherCodes.fromCode(it).name }
                    ?: WeatherCodes.fromCode(0).name,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
