package com.example.demo.repository;

import android.arch.lifecycle.LiveData;

import com.example.demo.model.weather.Weather;

public interface WeatherRepository {

    LiveData<Weather> getWeather(String location);

}