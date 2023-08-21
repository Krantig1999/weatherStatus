package com.example.myapplication.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.WeatherForecast
import com.example.myapplication.model.WeatherRepository
import com.example.myapplication.util.AppUtil
import com.example.myapplication.viewmodel.ViewModelFactory
import com.example.myapplication.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var weatherAdapter: WeatherAdapter

    private val forecastList = mutableListOf<WeatherForecast>()

    private lateinit var viewModel: WeatherViewModel

    private lateinit var selectedCity: String

    private lateinit var cityText:EditText

    private lateinit var btnFetchWeather: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityText = findViewById(R.id.autoCompleteCity)
        btnFetchWeather = findViewById(R.id.btnFetchWeather)

        viewModel = ViewModelProvider(
            this, ViewModelFactory(WeatherRepository())
        ).get(WeatherViewModel::class.java)

        setupRecyclerView()
        clickListeners()
        observerWeatherData()
        observeErrorData()
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        weatherAdapter = WeatherAdapter(forecastList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = weatherAdapter
    }


    private fun clickListeners() {
        btnFetchWeather.setOnClickListener {
            selectedCity = cityText.text.toString()
            val apiKey = AppUtil.apiKey
            viewModel.fetchWeather(selectedCity, apiKey)
        }
    }

    private fun observeErrorData() {
        viewModel.showError.observe(this, Observer { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        })
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun observerWeatherData() {
        viewModel.weatherLiveData.observe(this, Observer { response ->

            val weatherData = WeatherForecast(
                city = selectedCity,
                temperature = response.main.temp.toString(),
                description = response.weather[0].description
            )

            forecastList.clear()
            forecastList.add(weatherData)
            weatherAdapter.notifyDataSetChanged()
        })
    }

}
