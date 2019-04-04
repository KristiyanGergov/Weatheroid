package com.example.demo.network;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import com.example.demo.model.weather.Weather;
import com.example.demo.repository.WeatherRepository;
import com.example.demo.util.ConfigurationUtil;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepositoryNetwork implements WeatherRepository {

    private final WeatherAPI weatherAPI;

    @Inject
    public WeatherRepositoryNetwork(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }


    @Override
    public LiveData<Weather> getWeather(String location) {

        final MutableLiveData<Weather> liveData = new MutableLiveData<>();

        weatherAPI.getWeather(ConfigurationUtil.getWeather() + location,
                ConfigurationUtil.getWeatherKey()).enqueue(new Callback<Weather>() {

            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                if (response.isSuccessful()) {
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                //todo
            }
        });

        return Transformations.map(liveData, new Function<Weather, Weather>() {
            @Override
            public Weather apply(Weather input) {
                return input;
            }
        });
    }

}
