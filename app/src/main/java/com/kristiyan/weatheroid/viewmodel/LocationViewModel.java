package com.kristiyan.weatheroid.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.kristiyan.weatheroid.MainApplication;
import com.kristiyan.weatheroid.local.LocationRepositoryLocal;
import com.kristiyan.weatheroid.model.location.Location;
import com.kristiyan.weatheroid.model.location.LocationGetResult;
import com.kristiyan.weatheroid.network.LocationRepositoryNetwork;

import java.util.List;

import javax.inject.Inject;

public class LocationViewModel extends AndroidViewModel {

    @Inject
    LocationRepositoryNetwork locationRepositoryNetwork;

    @Inject
    LocationRepositoryLocal locationRepositoryLocal;

    public LocationViewModel(@NonNull Application application) {
        super(application);
        ((MainApplication) application).getAppComponent().inject(this);
    }

    private final MediatorLiveData<LocationGetResult> locationLiveData = new MediatorLiveData<>();

    public LiveData<LocationGetResult> getLocationLiveData() {
        return locationLiveData;
    }


    public void getLocationsOnline() {

        final LiveData<List<Location>> locationLiveDataNetwork = locationRepositoryNetwork.getAllLocations();

        locationLiveData.addSource(locationLiveDataNetwork, new Observer<List<Location>>() {
            @Override
            public void onChanged(@Nullable List<Location> locations) {
                locationLiveData.postValue(new LocationGetResult(locations));
                locationLiveData.removeSource(locationLiveDataNetwork);
            }
        });
    }


    public void getLocationsLocal() {

        final LiveData<List<Location>> locationsLiveDataLocal = locationRepositoryLocal.getAllLocations();

        locationLiveData.addSource(locationsLiveDataLocal, new Observer<List<Location>>() {
            @Override
            public void onChanged(@Nullable List<Location> locations) {
                locationLiveData.postValue(new LocationGetResult(locations));
                locationLiveData.removeSource(locationLiveData);
            }
        });


    }

}
