package com.jonnybizz.weatherapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherResponse (
    @SerializedName("cod")
    @Expose
    var cod: String? = null,

    @SerializedName("message")
    @Expose
    var message: Int? = null,

    @SerializedName("cnt")
    @Expose
    var cnt: Int? = null,

    @SerializedName("list")
    @Expose
    var list: kotlin.collections.List<WeatherList>? = null,

    @SerializedName("city")
    @Expose
    var city: City? = null
)