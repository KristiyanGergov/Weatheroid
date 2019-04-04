package com.example.demo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.demo.MainApplication;
import com.example.demo.local.LocationRepositoryLocal;
import com.example.demo.model.location.Location;
import com.example.demo.model.location.LocationGetResult;
import com.example.demo.model.location.LocationLocal;
import com.example.demo.network.LocationRepositoryNetwork;

import java.util.Set;

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

        final LiveData<Set<Location>> locationLiveDataNetwork = locationRepositoryNetwork.getAllLocations();

        locationLiveData.addSource(locationLiveDataNetwork, new Observer<Set<Location>>() {
            @Override
            public void onChanged(@Nullable Set<Location> locations) {
                locationLiveData.postValue(new LocationGetResult(locations));
                locationLiveData.removeSource(locationLiveDataNetwork);
            }
        });
    }


    public void getLocationsLocal() {

        final LiveData<Set<Location>> locationsLiveDataLocal = locationRepositoryLocal.getAllLocations();

        locationLiveData.addSource(locationsLiveDataLocal, new Observer<Set<Location>>() {
            @Override
            public void onChanged(@Nullable Set<Location> locations) {
                locationLiveData.postValue(new LocationGetResult(locations));
                locationLiveData.removeSource(locationLiveData);
            }
        });


    }

}
