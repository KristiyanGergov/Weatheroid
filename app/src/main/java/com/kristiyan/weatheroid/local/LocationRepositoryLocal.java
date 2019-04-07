package com.kristiyan.weatheroid.local;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;

import com.kristiyan.weatheroid.model.location.Location;
import com.kristiyan.weatheroid.model.location.LocationLocal;
import com.kristiyan.weatheroid.repository.LocationRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class LocationRepositoryLocal implements LocationRepository {


    private LocationDao locationDao;

    @Inject
    public LocationRepositoryLocal(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public LiveData<List<Location>> getAllLocations() {

        return Transformations.map(locationDao.getLocations(), new Function<List<LocationLocal>, List<Location>>() {
            @Override
            public List<Location> apply(List<LocationLocal> input) {

                List<Location> locations = new ArrayList<>();

                for (LocationLocal location : input) {
                    locations.add(location.toLocation());
                }

                return locations;
            }
        });
    }
}
