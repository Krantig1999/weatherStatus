package com.example.myapplication.model

data class WeatherForecast(
    var city: String,
    var temperature: String,
    var description: String,
)


data class WeatherResponse(
    val main: MainData,
    val weather: List<WeatherData>,

    )

data class MainData(
    val temp: Double
)

data class WeatherData(
    val description: String
)
