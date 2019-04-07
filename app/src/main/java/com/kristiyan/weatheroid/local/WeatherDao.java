package com.kristiyan.weatheroid.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.kristiyan.weatheroid.model.weather.WeatherLocal;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WeatherLocal weatherLocal);

}
