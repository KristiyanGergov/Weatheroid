package com.kristiyan.weatheroid.network;

import com.kristiyan.weatheroid.model.location.LocationNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationAPI {

    String URL = "https://restcountries.eu/rest/";

    @GET("v2/all")
    Call<List<LocationNetwork>> getAllLocations();


}