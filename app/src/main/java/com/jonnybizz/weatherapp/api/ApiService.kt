package com.jonnybizz.weatherapp.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // https://api.openweathermap.org/data/2.5/forecast?q={city}&appid={api key}
    // 65d00499677e59496ca2f318eb68c049

    @GET("forecast")
    fun getWeatherData(@Query("q") q:String,
                       @Query("appid") apiKey:String
    ):Single<WeatherResponse>
}