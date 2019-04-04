package com.example.demo.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.demo.model.weather.WeatherLocal;

import javax.inject.Singleton;

@Singleton
@Database(entities = {WeatherLocal.class}, version = 1)
public abstract class WeatherRoomDatabase extends RoomDatabase {

    public abstract WeatherDao weatherDao();

}