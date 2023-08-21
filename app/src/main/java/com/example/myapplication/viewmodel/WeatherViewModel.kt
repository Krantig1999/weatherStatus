package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.WeatherRepository
import com.example.myapplication.model.WeatherResponse
import com.example.myapplication.util.AppUtil
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _weatherLiveData = MutableLiveData<WeatherResponse>()
    val weatherLiveData: LiveData<WeatherResponse> = _weatherLiveData

    private val _showError = MutableLiveData<String>()
    val showError: LiveData<String> = _showError

    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val weatherResponse = repository.getWeather(city, apiKey).first()
                _weatherLiveData.postValue(weatherResponse)
            } catch (e: Exception) {
                e.printStackTrace()
                _showError.postValue(AppUtil.message)
            }
        }

    }
}

