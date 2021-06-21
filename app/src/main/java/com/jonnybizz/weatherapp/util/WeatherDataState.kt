package com.jonnybizz.weatherapp.util

import com.jonnybizz.weatherapp.model.WeatherContainer

sealed class WeatherDataState {
    data class Success(val data: List<WeatherContainer>) : WeatherDataState()
    data class Error(val msg: String) : WeatherDataState()
    object Loading : WeatherDataState()
    object Idle : WeatherDataState()
}
