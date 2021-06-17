package com.jonnybizz.weatherapp.api

import com.jonnybizz.weatherapp.models.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // https://api.openweathermap.org/data/2.5/forecast?q={city}&appid={api key}
    // 65d00499677e59496ca2f318eb68c049

    @GET("forecast")
    fun getWeatherData(@Query("q") q:String,
                       @Query("appid") apiKey:String = "65d00499677e59496ca2f318eb68c049"
    ): Single<WeatherResponse>
}