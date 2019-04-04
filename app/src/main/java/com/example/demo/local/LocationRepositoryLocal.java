package com.example.demo.local;

import android.arch.lifecycle.LiveData;

import com.example.demo.model.location.Location;
import com.example.demo.repository.LocationRepository;

import java.util.List;

public class LocationRepositoryLocal implements LocationRepository {


    private LocationDao locationDao;

    @Override
    public LiveData<List<Location>> getAllLocations() {
        return null;
    }
}
