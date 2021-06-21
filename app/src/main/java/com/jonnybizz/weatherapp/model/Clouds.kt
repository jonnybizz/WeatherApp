package com.jonnybizz.weatherapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Clouds(
    val all: Int? = null
) : Parcelable