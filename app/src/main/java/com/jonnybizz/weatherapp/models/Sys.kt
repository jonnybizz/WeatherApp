package com.jonnybizz.weatherapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
data class Sys (
    @SerializedName("pod")
    @Expose
    var pod: String? = null
)