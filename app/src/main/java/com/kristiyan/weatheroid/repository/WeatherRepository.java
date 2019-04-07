package com.kristiyan.weatheroid.repository;

import android.arch.lifecycle.LiveData;

import com.kristiyan.weatheroid.model.weather.Weather;

public interface WeatherRepository {

    LiveData<Weather> getWeather(String location);

}