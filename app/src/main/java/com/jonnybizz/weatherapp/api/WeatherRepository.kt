package com.jonnybizz.weatherapp.api

import com.jonnybizz.weatherapp.models.WeatherResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {
    var baseUrl = "https://api.openweathermap.org/data/2.5/"
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    var weatherApiService: ApiService = retrofit.create(ApiService::class.java)

    fun getWeather(city:String, apiKey:String):Single<WeatherResponse>{
        return weatherApiService.getWeatherData(city, apiKey)

    }
}

