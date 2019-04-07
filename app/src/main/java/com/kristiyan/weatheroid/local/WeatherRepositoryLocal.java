package com.kristiyan.weatheroid.local;

import android.arch.lifecycle.LiveData;

import com.kristiyan.weatheroid.model.weather.Weather;
import com.kristiyan.weatheroid.repository.WeatherRepository;

public class WeatherRepositoryLocal implements WeatherRepository {



    @Override
    public LiveData<Weather> getWeather(String location) {
        return null;
    }

}
