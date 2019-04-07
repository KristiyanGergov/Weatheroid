package com.kristiyan.weatheroid.model.location;

import java.util.List;

public class LocationGetResult {

    private final Exception exception;
    private final List<Location> locations;

    public LocationGetResult(Exception exception) {
        this.exception = exception;
        this.locations = null;
    }

    public LocationGetResult(List<Location> locations) {
        this.locations = locations;
        this.exception = null;
    }

    public Exception getException() {
        return exception;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public boolean success() {
        return locations != null;
    }
}
