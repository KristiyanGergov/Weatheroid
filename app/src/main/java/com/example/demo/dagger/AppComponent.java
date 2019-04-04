package com.example.demo.dagger;


import android.content.Context;
import android.support.annotation.NonNull;

import com.example.demo.MainApplication;
import com.example.demo.MainFragment;
import com.example.demo.local.LocationRoomDatabase;
import com.example.demo.local.WeatherRoomDatabase;
import com.example.demo.viewmodel.LocationViewModel;
import com.example.demo.viewmodel.WeatherViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public abstract class AppComponent {

    public static AppComponent from(@NonNull Context context) {
        return ((MainApplication) context.getApplicationContext()).getAppComponent();
    }

    public abstract void inject(LocationViewModel locationViewModel);

    public abstract void inject(MainFragment mainFragment);

    public abstract void inject(WeatherViewModel weatherViewModel);

    public abstract void inject(MainApplication mainApplication);

    public abstract void inject(WeatherRoomDatabase weatherRoomDatabase);

    public abstract void inject(LocationRoomDatabase locationRoomDatabase);
}
