package com.jonnybizz.weatherapp.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jonnybizz.weatherapp.R
import com.jonnybizz.weatherapp.databinding.FragmentSearchWeatherBinding
import com.jonnybizz.weatherapp.model.WeatherContainer
import com.jonnybizz.weatherapp.util.WeatherDataState
import com.jonnybizz.weatherapp.view.MainActivity
import com.jonnybizz.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchWeatherFragment : Fragment(R.layout.fragment_search_weather) {

    private lateinit var binding: FragmentSearchWeatherBinding
    private val weatherViewModel by viewModels<WeatherViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchWeatherBinding.bind(view).apply {
            weatherSearchBtn.setOnClickListener {
                val cityName = etSearch.text.toString()
                (requireActivity() as MainActivity).setTitle(cityName)
                weatherViewModel.loadWeatherList(cityName)
            }
        }

        weatherViewModel.weatherDataStateLD.observe(viewLifecycleOwner) { state ->
            when (state) {
                is WeatherDataState.Success -> toggleSuccess(state.data)
                is WeatherDataState.Error -> toggleError(state.msg)
                is WeatherDataState.Loading -> toggleLoader(true)
                is WeatherDataState.Idle -> {

                }
            }
        }
    }

    private fun toggleSuccess(data: List<WeatherContainer>) = with(binding) {
        toggleLoader(false)
        findNavController().navigate(SearchWeatherFragmentDirections.goToList(data.toTypedArray()))
        weatherViewModel.resetState()
        weatherSearchBtn.isEnabled = true
    }

    private fun toggleError(msg: String) = with(binding) {
        toggleLoader(false)
        ilSearch.error = msg
        ilSearch.isErrorEnabled = true
        weatherSearchBtn.isEnabled = true
    }

    private fun toggleLoader(isLoading: Boolean) = with(binding) {
        loader.isVisible = isLoading
        ilSearch.isErrorEnabled = false
        weatherSearchBtn.isEnabled = false
    }
}
