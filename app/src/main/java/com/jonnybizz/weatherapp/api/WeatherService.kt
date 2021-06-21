package com.jonnybizz.weatherapp.api

import com.jonnybizz.weatherapp.model.WeatherResponse
import com.jonnybizz.weatherapp.util.WeatherUnit
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    // https://api.openweathermap.org/data/2.5/forecast?q={city}&appid={api key}
    // 65d00499677e59496ca2f318eb68c049

    @GET("forecast")
    fun getWeatherData(
        @Query("q") city: String,
        @Query("appid") apiKey: String = "65d00499677e59496ca2f318eb68c049",
        @Query("units") units: String = WeatherUnit.IMPERIAL.name
    ): Single<WeatherResponse>
}