package com.example.myapplication.model

import com.example.myapplication.util.AppUtil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse

    companion object {
        fun create(): WeatherAPI {
            val retrofit = Retrofit.Builder().baseUrl(AppUtil.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit.create(WeatherAPI::class.java)
        }
    }
}
