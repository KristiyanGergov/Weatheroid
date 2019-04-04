package com.example.demo.repository;

import android.arch.lifecycle.LiveData;

import com.example.demo.model.location.Location;

import java.util.List;

public interface LocationRepository {

    LiveData<List<Location>> getAllLocations();
}
