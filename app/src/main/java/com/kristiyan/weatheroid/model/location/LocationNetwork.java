package com.kristiyan.weatheroid.model.location;

import com.google.gson.annotations.SerializedName;

public class LocationNetwork {

    @SerializedName("name")
    private String name;

    @SerializedName("region")
    private String region;


    public LocationNetwork(String code, String name, String region) {
        this.name = name;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public Location toLocation() {
        return new Location(name, region);
    }

}
