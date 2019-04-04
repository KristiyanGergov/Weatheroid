package com.example.demo.network;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import com.example.demo.model.location.Location;
import com.example.demo.model.location.LocationNetwork;
import com.example.demo.repository.LocationRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationRepositoryNetwork implements LocationRepository {

    private final LocationAPI locationAPI;

    @Inject
    public LocationRepositoryNetwork(LocationAPI locationAPI) {
        this.locationAPI = locationAPI;
    }

    @Override
    public LiveData<List<Location>> getAllLocations() {

        final MutableLiveData<List<LocationNetwork>> liveData = new MutableLiveData<>();

        locationAPI.getAllLocations().enqueue(new Callback<List<LocationNetwork>>() {
            @Override
            public void onResponse(Call<List<LocationNetwork>> call, Response<List<LocationNetwork>> response) {
                if (response.isSuccessful()) {
                    liveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<LocationNetwork>> call, Throwable t) {

            }
        });

        return Transformations.map(liveData, new Function<List<LocationNetwork>, List<Location>>() {
            @Override
            public List<Location> apply(List<LocationNetwork> input) {
                List<Location> locations = new ArrayList<>();

                for (LocationNetwork locationNetwork : input) {
                    locations.add(locationNetwork.toLocation());
                }
                return locations;
            }
        });
    }


}
