package com.jonnybizz.weatherapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Clouds (
    @SerializedName("all")
    @Expose
    var all: Int? = null
)