package com.kristiyan.weatheroid.repository;

import android.arch.lifecycle.LiveData;

import com.kristiyan.weatheroid.model.location.Location;

import java.util.List;

public interface LocationRepository {

    LiveData<List<Location>> getAllLocations();
}
