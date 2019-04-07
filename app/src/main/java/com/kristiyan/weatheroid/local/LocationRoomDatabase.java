package com.kristiyan.weatheroid.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.kristiyan.weatheroid.model.location.LocationLocal;

import javax.inject.Singleton;

@Singleton
@Database(entities = {LocationLocal.class}, version = 1)
public abstract class LocationRoomDatabase extends RoomDatabase {

    public abstract LocationDao locationDao();
}
