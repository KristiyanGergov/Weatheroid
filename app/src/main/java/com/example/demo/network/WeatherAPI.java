package com.example.demo.network;

import com.example.demo.model.weather.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface WeatherAPI {

    String URL = "http://api.apixu.com/v1/";

    @GET("/{p}")
    Call<Weather> getWeather(@Path("p") String location, String key);

}
