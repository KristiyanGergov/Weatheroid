package com.example.demo.local;

import android.arch.lifecycle.LiveData;

import com.example.demo.model.weather.Weather;
import com.example.demo.repository.WeatherRepository;

public class WeatherRepositoryLocal implements WeatherRepository {



    @Override
    public LiveData<Weather> getWeather(String location) {
        return null;
    }

}
