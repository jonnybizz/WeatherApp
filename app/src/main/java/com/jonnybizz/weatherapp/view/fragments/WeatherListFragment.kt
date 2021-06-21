package com.jonnybizz.weatherapp.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.jonnybizz.weatherapp.R
import com.jonnybizz.weatherapp.adapter.WeatherAdapter
import com.jonnybizz.weatherapp.databinding.FragmentWeatherListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherListFragment : Fragment(R.layout.fragment_weather_list) {

    private val args by navArgs<WeatherListFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentWeatherListBinding.bind(view).apply {
            rvWeather.adapter = WeatherAdapter(args.weatherContainerList.toList()) {
                findNavController().navigate(WeatherListFragmentDirections.goToDetail(it))
            }
        }
    }
}