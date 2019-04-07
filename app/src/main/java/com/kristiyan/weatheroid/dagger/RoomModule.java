package com.kristiyan.weatheroid.dagger;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.kristiyan.weatheroid.local.LocationDao;
import com.kristiyan.weatheroid.local.LocationRoomDatabase;
import com.kristiyan.weatheroid.local.WeatherDao;
import com.kristiyan.weatheroid.local.WeatherRoomDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private final WeatherRoomDatabase weatherRoomDatabase;
    private final LocationRoomDatabase locationRoomDatabase;

    public RoomModule(Application application) {
        weatherRoomDatabase = Room.databaseBuilder(application, WeatherRoomDatabase.class, "weather_database")
                .build();

        locationRoomDatabase = Room.databaseBuilder(application, LocationRoomDatabase.class, "location_database")
                .build();
    }

    @Provides
    @Singleton
    public WeatherDao providesWeatherDao(WeatherRoomDatabase weatherRoomDatabase) {
        return weatherRoomDatabase.weatherDao();
    }

    @Provides
    @Singleton
    public WeatherRoomDatabase providesWeatherRoomDatabase(Context context) {
        return weatherRoomDatabase;
    }

    @Provides
    @Singleton
    public LocationDao providesLocationDao(LocationRoomDatabase locationRoomDatabase) {
        return locationRoomDatabase.locationDao();
    }

    @Provides
    @Singleton
    public LocationRoomDatabase providesLocationRoomDatabase(Context context) {
        return locationRoomDatabase;
    }


}