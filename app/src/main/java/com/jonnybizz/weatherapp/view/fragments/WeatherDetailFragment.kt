package com.jonnybizz.weatherapp.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.jonnybizz.weatherapp.R
import com.jonnybizz.weatherapp.databinding.FragmentWeatherDetailBinding
import com.jonnybizz.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherDetailFragment : Fragment(R.layout.fragment_weather_detail) {

    private val args by navArgs<WeatherDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentWeatherDetailBinding.bind(view).apply {
            val weatherContainer = args.weatherContainer
            val na = root.context.getString(R.string.na)

            tvTemp.text = weatherContainer.main?.temp?.toString() ?: na
            tvTempDescription.text = "Feels Like: " + weatherContainer.main?.feelsLike?.toString() ?: na
            tvForecast.text = weatherContainer.weather?.first()?.main ?: na
            tvForecastDescription.text = weatherContainer.weather?.first()?.description ?: na

        }
    }
}