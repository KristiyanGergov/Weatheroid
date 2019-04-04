package com.example.demo.model.location;

import com.example.demo.model.location.Location;

import java.util.Set;

public class LocationGetResult {

    private final Exception exception;
    private final Set<Location> locations;

    public LocationGetResult(Exception exception) {
        this.exception = exception;
        this.locations = null;
    }

    public LocationGetResult(Set<Location> locations) {
        this.locations = locations;
        this.exception = null;
    }

    public Exception getException() {
        return exception;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    private boolean success() {
        return locations != null;
    }
}
