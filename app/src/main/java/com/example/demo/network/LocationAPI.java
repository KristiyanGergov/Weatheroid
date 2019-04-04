package com.example.demo.network;

import com.example.demo.model.location.LocationNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationAPI {

    String URL = "https://restcountries.eu/rest/v2";

    @GET("/all")
    Call<List<LocationNetwork>> getAllLocations();


}