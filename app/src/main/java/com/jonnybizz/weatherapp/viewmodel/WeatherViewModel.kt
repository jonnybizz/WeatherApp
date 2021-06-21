package com.jonnybizz.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jonnybizz.weatherapp.api.WeatherRepository
import com.jonnybizz.weatherapp.model.WeatherResponse
import com.jonnybizz.weatherapp.util.WeatherDataState
import com.jonnybizz.weatherapp.util.WeatherUnit
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private var disposable: CompositeDisposable = CompositeDisposable()

    private val weatherDataState: MutableLiveData<WeatherDataState> = MutableLiveData()
    val weatherDataStateLD: LiveData<WeatherDataState>
        get() = weatherDataState


    fun loadWeatherList(city: String, units: String = WeatherUnit.IMPERIAL.name) {
        disposable.add(
            weatherRepository.getWeather(city, units).subscribe(this::weatherSuccess, this::onError)
        )
    }

    private fun weatherSuccess(weather: WeatherResponse) {
        val state = weather.list?.let { WeatherDataState.Success(it) }
            ?: WeatherDataState.Error("No data found")
        weatherDataState.value = state
        Log.d("_log", "whole pizza box")
    }

    private fun onError(throwable: Throwable) {
        val errorMsg = throwable.message ?: "Something went wrong."
        weatherDataState.value = WeatherDataState.Error(errorMsg)
        Log.d("_log", "this is an error" + throwable.message)
    }


    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    fun resetState() {
        weatherDataState.value = WeatherDataState.Idle
    }
}


