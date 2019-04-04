package com.example.demo.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.demo.model.location.LocationLocal;

import javax.inject.Singleton;

@Singleton
@Database(entities = {LocationLocal.class}, version = 1)
public abstract class LocationRoomDatabase extends RoomDatabase {

    public abstract LocationDao locationDao();
}
