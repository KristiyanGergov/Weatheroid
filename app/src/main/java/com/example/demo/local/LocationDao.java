package com.example.demo.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.demo.model.location.LocationLocal;

import java.util.List;

@Dao
public interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LocationLocal location);

    @Query("DELETE FROM location_table")
    void deleteAll();

    @Query("SELECT * FROM location_table")
    LiveData<List<LocationLocal>> getLocations();
}