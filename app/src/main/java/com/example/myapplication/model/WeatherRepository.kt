package com.example.myapplication.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WeatherRepository {

    private var weatherAPI:WeatherAPI = WeatherAPI.create()

    suspend fun getWeather(city: String, apiKey: String): Flow<WeatherResponse> = flow {
        val weatherResponse = weatherAPI.getWeather(city, apiKey)
        emit(weatherResponse)
    }.flowOn(Dispatchers.IO)
}
