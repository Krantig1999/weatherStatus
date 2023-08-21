package com.example.myapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.myapplication.model.MainData
import com.example.myapplication.model.WeatherData
import com.example.myapplication.model.WeatherRepository
import com.example.myapplication.model.WeatherResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import androidx.lifecycle.LiveData
import com.example.myapplication.viewmodel.WeatherViewModel
import kotlinx.coroutines.flow.Flow
import org.junit.Assert.assertEquals
import org.mockito.Mockito.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


@OptIn(ExperimentalCoroutinesApi::class)
class WeatherViewModelTest {

    @get:Rule
    val coroutineScope = CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: WeatherRepository

    @Mock
    lateinit var response: Flow<WeatherResponse>

    lateinit var viewModel: WeatherViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = WeatherViewModel(repository)
    }


    @Test
    fun `fetchWeather success`() =coroutineScope.testDispatcher.runBlockingTest {
        `when`(repository.getWeather(anyString(), anyString())).thenReturn(response)
        // Call the fetchWeather function
        viewModel.fetchWeather("Sample_City", "Sample_Key")

        // Verify repository method called
        verify(repository).getWeather("Sample_City", "Sample_Key")

    }

}
