package com.example.demo.dagger;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.demo.local.LocationDao;
import com.example.demo.local.LocationRoomDatabase;
import com.example.demo.local.WeatherDao;
import com.example.demo.local.WeatherRoomDatabase;
import com.example.demo.model.location.Location;

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
    public WeatherDao providesWeatherDao(WeatherDao weatherDao) {
        return weatherDao;
    }

    @Provides
    @Singleton
    public WeatherRoomDatabase providesWeatherRoomDatabse(Context context) {
        return weatherRoomDatabase;
    }


    @Provides
    @Singleton
    public LocationDao providesLocationDao(LocationDao locationDao) {
        return locationDao;
    }

    @Provides
    @Singleton
    public LocationRoomDatabase providesLocationRoomDatabase(Context context) {
        return locationRoomDatabase;
    }


}